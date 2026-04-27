package com.ecoTaggy.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ecoTaggy.entity.ImpactoAmbiental;
import com.ecoTaggy.entity.Usuario;
import com.ecoTaggy.repository.PapelEconomizadoRepository;
import com.ecoTaggy.service.ImpactoService;
import com.ecoTaggy.service.UsuarioService;

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
            // Para a Entrega 3, tentamos buscar o usuário ID 1 como padrão.
            // Se não existir, renderizamos o dashboard com valores padrão.
            Usuario usuario;
            try {
                usuario = usuarioService.buscarPorId(1L);
            } catch (Exception e) {
                usuario = new Usuario();
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
            
            return "dashboard";
        } catch (Exception e) {
            System.err.println("Erro ao carregar Dashboard: " + e.getMessage());
            model.addAttribute("usuario", new Usuario());
            model.addAttribute("impacto", new ImpactoAmbiental());
            model.addAttribute("totalFolhas", 0);
            model.addAttribute("relatorio", new HashMap<>());
            return "dashboard";
        }
    }

}
