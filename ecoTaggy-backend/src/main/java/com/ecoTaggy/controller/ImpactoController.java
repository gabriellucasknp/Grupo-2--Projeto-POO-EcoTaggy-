package com.ecoTaggy.controller;


import com.ecoTaggy.entity.ImpactoAmbiental;
import com.ecoTaggy.entity.Usuario;
import com.ecoTaggy.service.ImpactoService;
import com.ecoTaggy.service.UsuarioService; // Precisamos disso para buscar o usuário pelo ID
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/impacto")
public class ImpactoController {


    private final ImpactoService impactoService;
    private final UsuarioService usuarioService;


    public ImpactoController(ImpactoService impactoService, UsuarioService usuarioService) {
        this.impactoService = impactoService;
        this.usuarioService = usuarioService;
    }


    // 1. Simulação (Usa o método que criamos no Service)
    @PostMapping("/simular")
    public ImpactoAmbiental simular(@RequestParam int volumeTransacoes) {
        return impactoService.simularImpacto(volumeTransacoes);
    }


    // 2. Cálculo Real (Agora buscando o usuário de verdade)
    @PostMapping("/calcular/{usuarioId}")
    public ImpactoAmbiental calcular(
            @PathVariable Long usuarioId, 
            @RequestParam String tipoOperacao) {
        
        // Buscamos o usuário no banco primeiro
        Usuario usuario = usuarioService.buscarPorId(usuarioId); 
        
        // Enviamos o objeto Usuario e o Tipo para o Service processar
        return impactoService.registrarPassagemReal(usuario, tipoOperacao);
    }
}


