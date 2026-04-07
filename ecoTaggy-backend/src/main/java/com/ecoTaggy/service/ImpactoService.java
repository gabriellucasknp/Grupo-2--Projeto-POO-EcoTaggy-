package com.ecoTaggy.service;

import com.ecoTaggy.entity.ImpactoAmbiental;
import com.ecoTaggy.entity.Transacao;
import com.ecoTaggy.repository.ImpactoAmbientalRepository;
import com.ecoTaggy.repository.TransacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImpactoService {

    private final ImpactoAmbientalRepository impactoRepository;
    private final TransacaoRepository transacaoRepository;

    // 🔹 Método principal (reutilizável)
    public ImpactoAmbiental calcularImpacto(Long transacaoId, int volumeTransacoes) {

        Transacao transacao = transacaoRepository.findById(transacaoId)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada"));

        // 📊 Coeficientes
        double co2 = volumeTransacoes * 0.05;
        double papel = volumeTransacoes * 0.002;
        double combustivel = volumeTransacoes * 0.01;

        ImpactoAmbiental impacto = new ImpactoAmbiental();
        impacto.setTransacao(transacao);
        impacto.setCo2Evitado(co2);
        impacto.setPapelEconomizado(papel);
        impacto.setCombustivelSalvo(combustivel);

        return impactoRepository.save(impacto);
    }

    // 🔹 Método só de cálculo (sem persistência)
    public ImpactoAmbiental simularImpacto(int volumeTransacoes) {

        ImpactoAmbiental impacto = new ImpactoAmbiental();

        impacto.setCo2Evitado(volumeTransacoes * 0.05);
        impacto.setPapelEconomizado(volumeTransacoes * 0.002);
        impacto.setCombustivelSalvo(volumeTransacoes * 0.01);

        return impacto;
    }
}
