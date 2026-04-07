package com.ecoTaggy.controller;

import com.ecoTaggy.entity.ImpactoAmbiental;
import com.ecoTaggy.service.ImpactoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/impacto")
@RequiredArgsConstructor
public class ImpactoController {

    private final ImpactoService impactoService;

    // 🔹 Simulação (não salva no banco)
    @PostMapping("/simular")
    public ImpactoAmbiental simular(@RequestParam int volumeTransacoes) {
        return impactoService.simularImpacto(volumeTransacoes);
    }

    // 🔹 Cálculo real (salva no banco)
    @PostMapping("/calcular/{transacaoId}")
    public ImpactoAmbiental calcular(
            @PathVariable Long transacaoId,
            @RequestParam int volumeTransacoes
    ) {
        return impactoService.calcularImpacto(transacaoId, volumeTransacoes);
    }
}
