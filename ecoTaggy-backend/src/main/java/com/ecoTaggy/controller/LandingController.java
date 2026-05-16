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
        Usuario usuario = usuarioService.buscarPorIdOptional(1L).orElseGet(Usuario::new);
        model.addAttribute("usuario", usuario);
        return "landing";
    }
}


