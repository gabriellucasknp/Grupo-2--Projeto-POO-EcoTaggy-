package com.ecoTaggy.controller;

import com.ecoTaggy.entity.Usuario;
import com.ecoTaggy.service.ImpactoService;
import com.ecoTaggy.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(TransacaoController.class)
class TransacaoControllerWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ImpactoService impactoService;

    @MockBean
    private UsuarioService usuarioService;

    @Test
    void paginaTransacaoSemUsuarioRedirecionaParaLogin() throws Exception {
        when(usuarioService.buscarPorIdOptional(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/transacao"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login?erro=usuario-nao-encontrado"));
    }

    @Test
    void confirmarTransacaoComUsuarioValidoRedirecionaComSucesso() throws Exception {
        Usuario usuario = new Usuario();
        when(usuarioService.buscarPorId(1L)).thenReturn(usuario);

        mockMvc.perform(post("/transacao/confirmar")
                        .param("usuarioId", "1")
                        .param("tipo", "PEDAGIO"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/landing?transacao_sucesso=true"));

        verify(impactoService).registrarPassagemReal(usuario, "PEDAGIO");
    }
}
