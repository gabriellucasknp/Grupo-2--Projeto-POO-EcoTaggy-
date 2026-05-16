package com.ecoTaggy.controller;

import com.ecoTaggy.entity.ImpactoAmbiental;
import com.ecoTaggy.entity.Usuario;
import com.ecoTaggy.service.ImpactoService;
import com.ecoTaggy.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ImpactoController.class)
class ImpactoControllerWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ImpactoService impactoService;

    @MockBean
    private UsuarioService usuarioService;

    @Test
    void calcularQuandoUsuarioNaoExisteRetornaNotFound() throws Exception {
        when(usuarioService.buscarPorIdOptional(99L)).thenReturn(Optional.empty());

        mockMvc.perform(post("/api/impacto/calcular/99")
                        .param("tipoOperacao", "PEDAGIO")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isNotFound());
    }

    @Test
    void simularRetornaImpactoCalculado() throws Exception {
        ImpactoAmbiental impacto = new ImpactoAmbiental();
        impacto.setCo2Evitado(15.0);
        impacto.setPapelEconomizado(1.0);
        impacto.setCombustivelEconomizado(5.0);
        impacto.setTransacoesProcessadas(100);

        when(impactoService.simularImpacto(100)).thenReturn(impacto);

        mockMvc.perform(post("/api/impacto/simular")
                        .param("volumeTransacoes", "100"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.co2Evitado").value(15.0))
                .andExpect(jsonPath("$.transacoesProcessadas").value(100));
    }
}
