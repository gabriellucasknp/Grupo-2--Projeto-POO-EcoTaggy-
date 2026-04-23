package com.ecoTaggy.controller;


import com.ecoTaggy.entity.Usuario;
import com.ecoTaggy.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LandingController {


    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/landing")
    public String exibirLanding(Model model) {
        // Para a Entrega 3, vamos buscar o usuário ID 1 como padrão
        // (Em um sistema real com login, usaríamos o usuário autenticado)
        try {
            Usuario usuario = usuarioService.buscarPorId(1L);
            model.addAttribute("usuario", usuario);
        } catch (Exception e) {
            // Se o banco estiver vazio, criamos um objeto vazio para não quebrar a tela
            model.addAttribute("usuario", new Usuario());
        }
        return "landing";
    }
}


