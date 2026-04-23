package com.ecoTaggy.controller;

import com.ecoTaggy.entity.Usuario;
import com.ecoTaggy.service.ImpactoService;
import com.ecoTaggy.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class ViewController {

    private final ImpactoService impactoService;
    private final UsuarioService usuarioService;

    public ViewController(ImpactoService impactoService, UsuarioService usuarioService) {
        this.impactoService = impactoService;
        this.usuarioService = usuarioService;
    }

    @GetMapping("/")
    public String exibirIndex() {
        return "index"; 
    }

    @GetMapping("/login")
    public String exibirLogin() {
        return "login";
    }

    @GetMapping("/cadastro")
    public String exibirCadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro";
    }

    @PostMapping("/cadastrar")
    public String processarCadastro(@ModelAttribute("usuario") Usuario usuario) {
        try {
            usuarioService.cadastrarUsuario(usuario);
            return "redirect:/login?sucesso";
        } catch (Exception e) {
            return "redirect:/cadastro?erro=" + e.getMessage();
        }
    }

    @GetMapping("/dashboard")
    public String exibirDashboard(Model model) {
        // 1. Chamamos a lógica de relatório que você criou no ImpactoService
        Map<String, Object> relatorio = impactoService.gerarRelatorioESG();

        // 2. Passamos os dados reais para o Thymeleaf
        // Nota: Usei os nomes que estão no seu HTML do Dashboard
        model.addAttribute("co2Total", relatorio.get("co2Total"));
        model.addAttribute("papelTotal", relatorio.get("papelTotal"));
        model.addAttribute("combustivelPoupado", relatorio.get("combustivelTotal"));
        model.addAttribute("ticketsEvitados", relatorio.get("papelTotal")); // Mapeado para o ticket
        
        // 3. Lógica extra para as árvores
        double co2Val = Double.parseDouble(relatorio.get("co2Total").toString().replace(",", "."));
        int arvores = (int) (co2Val / 20); // 1 árvore para cada 20kg de CO2
        model.addAttribute("arvoresSalvas", arvores);

        // 4. Dados extras para o Banner ESG no final do HTML
        model.addAttribute("dataGeracao", relatorio.get("dataGeracao"));
        model.addAttribute("metodologia", relatorio.get("metodologia"));
        
        return "dashboard";
    }

    @GetMapping("/simulador")
    public String exibirSimulador() {
        return "simulador"; 
    }
}