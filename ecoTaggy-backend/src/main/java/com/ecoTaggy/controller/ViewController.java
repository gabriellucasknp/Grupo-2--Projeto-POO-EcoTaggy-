package com.ecoTaggy.controller;

import com.ecoTaggy.service.ImpactoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    private final ImpactoService impactoService;

    public ViewController(ImpactoService impactoService) {
        this.impactoService = impactoService;
    }

    // 1. Vitrine Pública (Versão Limitada)
    // Aparece ao abrir o site pela primeira vez
    @GetMapping("/")
    public String exibirIndex() {
        return "index"; 
    }

    // 2. Portal de Entrada (A Landing Page "Ponte")
    // O usuário cai aqui APÓS o login/cadastro para acessar as ferramentas
    @GetMapping("/landing")
    public String exibirLanding() {
        return "landing"; 
    }

    // 3. Telas de Acesso
    @GetMapping("/login")
    public String exibirLogin() {
        return "login";
    }

    @GetMapping("/cadastro")
    public String exibirCadastro() {
        return "cadastro";
    }

    // 4. Funcionalidades (Acessadas via Landing)
    @GetMapping("/dashboard")
    public String exibirDashboard(Model model) {
        model.addAttribute("co2Total", "3.900");
        model.addAttribute("arvoresSalvas", "185");
        model.addAttribute("combustivelPoupado", "2.340");
        model.addAttribute("ticketsEvitados", "8.200");
        
        return "dashboard";
    }

    @GetMapping("/simulador")
    public String exibirSimulador() {
        return "simulador"; 
    }
}