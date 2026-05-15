package com.ecoTaggy.controller;

import com.ecoTaggy.entity.ImpactoAmbiental;
import com.ecoTaggy.entity.Usuario;
import com.ecoTaggy.service.ImpactoService;
import com.ecoTaggy.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;

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
        return "redirect:/landing"; 
    }

    @GetMapping("/login")
    public String exibirLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String processarLogin(@RequestParam String email, @RequestParam String senha, HttpSession session) {
        // Implementação realística de sessão. 
        // Em produção, buscaríamos por e-mail no banco e validaríamos a senha (Hash).
        if (email != null && !email.isEmpty() && senha != null && !senha.isEmpty()) {
            session.setAttribute("usuarioLogadoId", 1L); // Simula acesso seguro associado ao ID da entidade
            return "redirect:/";
        }
        return "redirect:/login?erro=Credenciais inválidas";
    }

    @GetMapping("/logout")
    public String realizarLogout(HttpSession session) {
        session.invalidate(); // Destrói a sessão e protege a conta
        return "redirect:/login?logout";
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

    // --- NOVOS MÓDULOS (Traduzidos do React para Thymeleaf) ---
    
    @GetMapping("/simulador")
    public String exibirSimulador(Model model, HttpSession session) {
        adicionarUsuarioAoModel(model, session);
        return "simulador"; 
    }
    
    @GetMapping("/calculadora")
    public String exibirCalculadora(Model model, HttpSession session) {
        adicionarUsuarioAoModel(model, session);
        return "calculadora"; 
    }
    
    @GetMapping("/impacto-pedagio")
    public String exibirImpactoPedagio(Model model, HttpSession session) {
        adicionarUsuarioAoModel(model, session);
        return "impacto-pedagio"; 
    }
    
    @GetMapping("/relatorio-ghg")
    public String exibirRelatorioGhg(Model model, HttpSession session) {
        adicionarUsuarioAoModel(model, session);
        return "relatorio-ghg"; 
    }
    
    @GetMapping("/simular-passagem")
    public String exibirSimularPassagem(Model model, HttpSession session) {
        adicionarUsuarioAoModel(model, session);
        return "simular-passagem"; 
    }

    @GetMapping("/economia-papel")
    public String exibirEconomiaPapel(Model model, HttpSession session) {
        adicionarUsuarioAoModel(model, session);
        return "economia-papel"; 
    }

    @GetMapping("/configuracoes")
    public String exibirConfiguracoes(Model model, HttpSession session) {
        adicionarUsuarioAoModel(model, session);
        return "configuracoes"; 
    }

    @GetMapping("/metas")
    public String exibirMetas(Model model, HttpSession session) {
        adicionarUsuarioAoModel(model, session);
        return "metas"; 
    }

    @GetMapping("/ranking")
    public String exibirRanking(Model model, HttpSession session) {
        adicionarUsuarioAoModel(model, session);
        return "ranking"; 
    }

    // Método auxiliar para evitar repetição e garantir o carregamento do cabeçalho
    private void adicionarUsuarioAoModel(Model model, HttpSession session) {
        try {
            Long id = (Long) session.getAttribute("usuarioLogadoId");
            if (id == null) id = 1L; // Fallback para não quebrar a tela durante seus testes locais
            Usuario usuario = usuarioService.buscarPorId(id);
            model.addAttribute("usuario", usuario);
            model.addAttribute("impacto", usuario.getImpacto() != null ? usuario.getImpacto() : new ImpactoAmbiental());
        } catch (Exception e) {
            model.addAttribute("usuario", new Usuario());
            model.addAttribute("impacto", new ImpactoAmbiental());
        }
    }
}