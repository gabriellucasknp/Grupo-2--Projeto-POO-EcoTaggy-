package com.ecoTaggy.controller;

import com.ecoTaggy.entity.Usuario;
import com.ecoTaggy.exception.DuplicateEmailException;
import com.ecoTaggy.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(ViewController.class)
@Import(GlobalExceptionHandler.class)
class ViewControllerWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UsuarioService usuarioService;

    @Test
    void cadastroComEmailDuplicadoRedirecionaParaFormularioComCodigoEstavel() throws Exception {
        doThrow(new DuplicateEmailException("Este e-mail já está em uso!"))
                .when(usuarioService).cadastrarUsuario(any(Usuario.class));

        mockMvc.perform(post("/cadastrar")
                        .param("nome", "Eco")
                        .param("email", "eco@taggy.com")
                        .param("senha", "123"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/cadastro?erro=email-em-uso"));
    }

    @Test
    void simuladorSemUsuarioRenderizaComModeloVazio() throws Exception {
        when(usuarioService.buscarPorIdOptional(1L)).thenReturn(java.util.Optional.empty());

        mockMvc.perform(get("/simulador"))
                .andExpect(status().isOk())
                .andExpect(view().name("simulador"))
                .andExpect(model().attributeExists("usuario", "impacto"));
    }
}
