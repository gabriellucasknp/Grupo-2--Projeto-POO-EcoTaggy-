package com.ecoTaggy.controller;


import com.ecoTaggy.entity.Usuario;
import com.ecoTaggy.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/perfil")
public class ConfigController {


    @Autowired
    private UsuarioService usuarioService;


    /**
     * 🟢 EXIBIR PERFIL
     * Abre a página de configurações com os dados do usuário logado.
     */
    @GetMapping("/{id}")
    public String exibirPerfil(@PathVariable Long id, Model model) {
        try {
            Usuario usuario = usuarioService.buscarPorId(id);
            model.addAttribute("usuario", usuario);
            return "perfil";
        } catch (Exception e) {
            // Se o ID não existir, manda de volta para a landing
            return "redirect:/landing";
        }
    }


    /**
     * 🔵 ATUALIZAR PERFIL
     * Recebe os dados do formulário do perfil.html e salva no banco.
     */
    @PostMapping("/atualizar")
    public String atualizarPerfil(@RequestParam Long id, 
                                   @RequestParam String nome, 
                                   @RequestParam(required = false) String novaSenha,
                                   @RequestParam("imagemArquivo") MultipartFile imagemArquivo) {
        
        try {
            // Chama o método que ajustamos no seu UsuarioService
            usuarioService.atualizarPerfil(id, nome, novaSenha, imagemArquivo);
            
            // Redireciona de volta para a página de perfil com aviso de sucesso
            return "redirect:/perfil/" + id + "?sucesso=true";
        } catch (Exception e) {
            // Se der erro, volta para a página com erro (você pode tratar isso na tela depois)
            return "redirect:/perfil/" + id + "?erro=true";
        }
    }
}



