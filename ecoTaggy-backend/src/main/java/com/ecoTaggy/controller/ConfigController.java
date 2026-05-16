package com.ecoTaggy.controller;


import com.ecoTaggy.entity.Usuario;
import com.ecoTaggy.exception.ProfileImageProcessingException;
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
        Long id = (Long) session.getAttribute("usuarioLogadoId");
        if (id == null) {
            id = 1L;
        }

        return usuarioService.buscarPorIdOptional(id)
                .map(usuario -> {
                    model.addAttribute("usuario", usuario);
                    return "perfil";
                })
                .orElse("redirect:/landing?erro=usuario-nao-encontrado");
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
            usuarioService.atualizarPerfil(id, nome, novaSenha, imagemArquivo);
            return "redirect:/" + origem + "?sucesso=true";
        } catch (ProfileImageProcessingException e) {
            return "redirect:/" + origem + "?erro=imagem-invalida";
        }
    }
}
