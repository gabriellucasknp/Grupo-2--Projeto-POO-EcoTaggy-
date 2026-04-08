package com.ecoTaggy.service;

import com.ecoTaggy.entity.ImpactoAmbiental;
import com.ecoTaggy.entity.Transacao;
import com.ecoTaggy.repository.ImpactoAmbientalRepository;
import com.ecoTaggy.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

@Service
public class ImpactoService {

    private final ImpactoAmbientalRepository impactoRepository;
    private final TransacaoRepository transacaoRepository;

    // 1. Construtor manual substituindo o Lombok (@RequiredArgsConstructor)
    public ImpactoService(ImpactoAmbientalRepository impactoRepository, TransacaoRepository transacaoRepository) {
        this.impactoRepository = impactoRepository;
        this.transacaoRepository = transacaoRepository;
    }

    // 🔹 Método principal (reutilizável)
    public ImpactoAmbiental calcularImpacto(Long transacaoId, int volumeTransacoes) {

        // 📊 Coeficientes (Atendendo aos requisitos do Documento)
        double co2 = volumeTransacoes * 0.05;
        double papel = volumeTransacoes * 0.002;
        double combustivel = volumeTransacoes * 0.01;

        ImpactoAmbiental impacto = new ImpactoAmbiental();
        
        impacto.setCo2Evitado(co2);
        impacto.setPapelEconomizado(papel);
        impacto.setCombustivelEconomizado(combustivel);

        return impactoRepository.save(impacto);
    }

    // 🔹 Método só de cálculo (sem persistência)
    public ImpactoAmbiental simularImpacto(int volumeTransacoes) {

        ImpactoAmbiental impacto = new ImpactoAmbiental();

        impacto.setCo2Evitado(volumeTransacoes * 0.05);
        impacto.setPapelEconomizado(volumeTransacoes * 0.002);
        impacto.setCombustivelEconomizado(volumeTransacoes * 0.01); // Corrigido para bater com a Entidade

        return impacto;
    }
}