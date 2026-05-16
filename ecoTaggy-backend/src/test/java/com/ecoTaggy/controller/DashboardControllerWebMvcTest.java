package com.ecoTaggy.controller;

import com.ecoTaggy.entity.ImpactoAmbiental;
import com.ecoTaggy.entity.PapelEconomizado;
import com.ecoTaggy.entity.Usuario;
import com.ecoTaggy.repository.PapelEconomizadoRepository;
import com.ecoTaggy.service.ImpactoService;
import com.ecoTaggy.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(DashboardController.class)
class DashboardControllerWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PapelEconomizadoRepository papelEconomizadoRepository;

    @MockBean
    private UsuarioService usuarioService;

    @MockBean
    private ImpactoService impactoService;

    @Test
    void dashboardCarregaIndicadoresComDadosDoUsuario() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNome("Eco User");

        ImpactoAmbiental impacto = new ImpactoAmbiental();
        impacto.setCo2Evitado(12.0);
        usuario.setImpacto(impacto);

        PapelEconomizado papel = new PapelEconomizado();
        papel.setQuantidadeFolhas(7);

        when(usuarioService.buscarPorIdOptional(1L)).thenReturn(Optional.of(usuario));
        when(papelEconomizadoRepository.findAll()).thenReturn(List.of(papel));
        when(impactoService.gerarRelatorioESG()).thenReturn(Map.of("co2Total", "12.000"));

        mockMvc.perform(get("/dashboard"))
                .andExpect(status().isOk())
                .andExpect(view().name("dashboard"))
                .andExpect(model().attributeExists("usuario", "impacto", "totalFolhas", "relatorio"))
                .andExpect(model().attribute("totalFolhas", 7));
    }
}
