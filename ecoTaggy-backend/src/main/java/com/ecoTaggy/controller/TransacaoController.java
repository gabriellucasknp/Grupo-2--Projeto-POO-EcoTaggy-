package com.ecoTaggy.controller;


import com.ecoTaggy.entity.Usuario;
import com.ecoTaggy.service.ImpactoService;
import com.ecoTaggy.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/transacao")
public class TransacaoController {


    @Autowired
    private ImpactoService impactoService;
    
    @Autowired
    private UsuarioService usuarioService;


    // 1. Rota para abrir a página transacao.html
    @GetMapping
    public String exibirPaginaTransacao(Model model) {
        try {
            // Buscamos o teu usuário (ID 1L para teste) para exibir os dados e a foto no header
            Usuario usuario = usuarioService.buscarPorId(1L);
            model.addAttribute("usuario", usuario);
            return "transacao"; 
        } catch (Exception e) {
            // Trata o erro (usuário inexistente, ID incorreto) e evita a Whitelabel error page
            System.err.println("Erro ao carregar página de Transação: " + e.getMessage());
            return "redirect:/login?erro=UsuarioNaoEncontrado";
        }
    }


    // 2. Rota que o botão "Confirmar" do formulário vai chamar
    @PostMapping("/confirmar")
    public String realizarTransacao(@RequestParam Long usuarioId, @RequestParam String tipo) {
        Usuario usuario = usuarioService.buscarPorId(usuarioId);
        
        // Chamamos o método que criaste no ImpactoService para salvar no banco
        impactoService.registrarPassagemReal(usuario, tipo);
        
        // Redireciona para a landing page com um parâmetro de sucesso
        return "redirect:/landing?transacao_sucesso=true";
    }
}
