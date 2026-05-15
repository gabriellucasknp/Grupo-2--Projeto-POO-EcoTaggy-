package com.ecoTaggy.controller;


import com.ecoTaggy.entity.Usuario;
import com.ecoTaggy.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("/perfil")
public class ConfigController {


    @Autowired
    private UsuarioService usuarioService;


    /**
     * 🟢 EXIBIR PERFIL
     * Abre a página de configurações com os dados do usuário logado.
     */
    @GetMapping
    public String exibirPerfil(HttpSession session, Model model) {
        try {
            Long id = (Long) session.getAttribute("usuarioLogadoId");
            if (id == null) id = 1L;
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
                                   @RequestParam(required = false, defaultValue = "perfil") String origem,
                                   @RequestParam("imagemArquivo") MultipartFile imagemArquivo) {
        
        try {
            // Chama o método que ajustamos no seu UsuarioService
            usuarioService.atualizarPerfil(id, nome, novaSenha, imagemArquivo);
            
            // Retorna EXATAMENTE para a aba (perfil ou configurações) que emitiu o Post
            return "redirect:/" + origem + "?sucesso=true";
        } catch (Exception e) {
            return "redirect:/" + origem + "?erro=true";
        }
    }
}
