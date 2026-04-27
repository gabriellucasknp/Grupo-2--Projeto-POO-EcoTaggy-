package com.ecoTaggy.controller;

<<<<<<< HEAD
import com.ecoTaggy.entity.Usuario;
import com.ecoTaggy.service.UsuarioService;
import com.ecoTaggy.service.ImpactoService;
=======
import java.util.HashMap;
import java.util.Map;

>>>>>>> 7f44aafeaf45c2bbd72851f7a737ddb4feb635bd
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import com.ecoTaggy.repository.PapelEconomizadoRepository;
import com.ecoTaggy.entity.ImpactoAmbiental;

import java.util.HashMap;
import java.util.Map;
=======

import com.ecoTaggy.entity.ImpactoAmbiental;
import com.ecoTaggy.entity.Usuario;
import com.ecoTaggy.repository.PapelEconomizadoRepository;
import com.ecoTaggy.service.ImpactoService;
import com.ecoTaggy.service.UsuarioService;
>>>>>>> 7f44aafeaf45c2bbd72851f7a737ddb4feb635bd

@Controller

public class DashboardController {
    
    @Autowired
    private PapelEconomizadoRepository papelEconomizadoRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ImpactoService impactoService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        try {
<<<<<<< HEAD
            // Para a Entrega 3, vamos buscar o usuário ID 1 como padrão
            Usuario usuario = usuarioService.buscarPorId(1L);    

            // PROTEÇÂO BÁSICA: Se o usuário não existir, redirecionamos para a página de login
            if (usuario == null) {
                return "redirect:/login?erro=UsuarioNaoEncontrado";
=======
            // Para a Entrega 3, tentamos buscar o usuário ID 1 como padrão.
            // Se não existir, renderizamos o dashboard com valores padrão.
            Usuario usuario;
            try {
                usuario = usuarioService.buscarPorId(1L);
            } catch (Exception e) {
                usuario = new Usuario();
>>>>>>> 7f44aafeaf45c2bbd72851f7a737ddb4feb635bd
            }

            model.addAttribute("usuario", usuario);
            
            // PREVENÇÃO THYMELEAF NULL POINTER: Envia um impacto zerado se o usuário não possuir um
            model.addAttribute("impacto", usuario.getImpacto() != null ? usuario.getImpacto() : new ImpactoAmbiental());

            var registrosPapel = papelEconomizadoRepository.findAll();

            // Proteção Anti-Null: Garantir que o valor seja sempre um número, mesmo que o banco retorne null
            int totalFolhas = registrosPapel.stream()
                    .mapToInt(reg -> reg.getQuantidadeFolhas() != null ? reg.getQuantidadeFolhas() : 0)
                    .sum();

            model.addAttribute("totalFolhas", totalFolhas);

            // PREVENÇÃO THYMELEAF NULL POINTER: Envia o objeto relatorio para a view
            Map<String, Object> relatorio = impactoService.gerarRelatorioESG();
            model.addAttribute("relatorio", relatorio != null ? relatorio : new HashMap<>());
            
<<<<<<< HEAD
            return "dashboard"; 
        } catch (Exception e) {
            System.err.println("Erro ao carregar Dashboard: " + e.getMessage());
            return "redirect:/login?erro=ErroInterno";
=======
            return "dashboard";
        } catch (Exception e) {
            System.err.println("Erro ao carregar Dashboard: " + e.getMessage());
            model.addAttribute("usuario", new Usuario());
            model.addAttribute("impacto", new ImpactoAmbiental());
            model.addAttribute("totalFolhas", 0);
            model.addAttribute("relatorio", new HashMap<>());
            return "dashboard";
>>>>>>> 7f44aafeaf45c2bbd72851f7a737ddb4feb635bd
        }
    }

}
