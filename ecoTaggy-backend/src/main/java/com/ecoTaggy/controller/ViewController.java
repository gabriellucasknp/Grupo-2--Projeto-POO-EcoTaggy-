package com.ecoTaggy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    // Rota da Landing Page (Página Inicial)
    @GetMapping("/")
    public String exibirLandingPage() {
        return "index"; // Aponta para index.html
    }

    // Rota para a Issue #05 (Dashboard com dados dinâmicos)
    @GetMapping("/dashboard")
    public String exibirDashboard(Model model) {
        // Simulando dados vindo do banco de dados (ImpactoService)
        // Na vida real, você chamaria: impactoService.obterResumoTotal();
        model.addAttribute("co2Total", "3.900");
        model.addAttribute("arvoresSalvas", "185");
        model.addAttribute("combustivelPoupado", "2.340");
        model.addAttribute("ticketsEvitados", "8.200");
        
        return "dashboard"; // Aponta para dashboard.html
    }

    // Rota para a Issue #06 (Simulador)
    @GetMapping("/simulador")
    public String exibirSimulador() {
        return "simulador"; 
    }
}