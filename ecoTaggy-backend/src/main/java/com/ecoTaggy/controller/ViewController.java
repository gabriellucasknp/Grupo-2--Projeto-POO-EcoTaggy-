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

    // --- NOVOS MÓDULOS (Traduzidos do React para Thymeleaf) ---
    
    @GetMapping("/simulador")
    public String exibirSimulador() {
        return "simulador"; 
    }
    
    @GetMapping("/calculadora")
    public String exibirCalculadora() {
        return "calculadora"; 
    }
    
    @GetMapping("/impacto-pedagio")
    public String exibirImpactoPedagio() {
        return "impacto-pedagio"; 
    }
    
    @GetMapping("/relatorio-ghg")
    public String exibirRelatorioGhg() {
        return "relatorio-ghg"; 
    }
    
    @GetMapping("/simular-passagem")
    public String exibirSimularPassagem() {
        return "simular-passagem"; 
    }
}