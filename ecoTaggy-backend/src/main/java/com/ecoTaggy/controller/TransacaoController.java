package com.ecoTaggy.controller;


import com.ecoTaggy.entity.Usuario;
import com.ecoTaggy.service.ImpactoService;
import com.ecoTaggy.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/transacao")
public class TransacaoController {


    @Autowired
    private ImpactoService impactoService;
    
    @Autowired
    private UsuarioService usuarioService;


    // 1. Rota para abrir a página transacao.html
    @GetMapping
    public String exibirPaginaTransacao(Model model, HttpSession session) {
        Long id = (Long) session.getAttribute("usuarioLogadoId");
        if (id == null) {
            id = 1L;
        }

        return usuarioService.buscarPorIdOptional(id)
                .map(usuario -> {
                    model.addAttribute("usuario", usuario);
                    return "transacao";
                })
                .orElse("redirect:/login?erro=usuario-nao-encontrado");
    }


    @PostMapping("/confirmar")
    public String realizarTransacao(@RequestParam Long usuarioId, @RequestParam String tipo) {
        Usuario usuario = usuarioService.buscarPorId(usuarioId);
        impactoService.registrarPassagemReal(usuario, tipo);
        return "redirect:/landing?transacao_sucesso=true";
    }
}
