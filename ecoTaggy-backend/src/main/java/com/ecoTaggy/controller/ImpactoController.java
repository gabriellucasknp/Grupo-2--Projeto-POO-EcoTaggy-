package com.ecoTaggy.controller;


import com.ecoTaggy.entity.ImpactoAmbiental;
import com.ecoTaggy.entity.Usuario;
import com.ecoTaggy.service.ImpactoService;
import com.ecoTaggy.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api/impacto")
public class ImpactoController {


    private final ImpactoService impactoService;
    private final UsuarioService usuarioService;


    public ImpactoController(ImpactoService impactoService, UsuarioService usuarioService) {
        this.impactoService = impactoService;
        this.usuarioService = usuarioService;
    }


    @PostMapping("/simular")
    public ImpactoAmbiental simular(@RequestParam int volumeTransacoes) {
        return impactoService.simularImpacto(volumeTransacoes);
    }


    @PostMapping("/calcular/{usuarioId}")
    public ImpactoAmbiental calcular(
            @PathVariable Long usuarioId, 
            @RequestParam String tipoOperacao) {
        Usuario usuario = usuarioService.buscarPorIdOptional(usuarioId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado."));
        return impactoService.registrarPassagemReal(usuario, tipoOperacao);
    }
}


