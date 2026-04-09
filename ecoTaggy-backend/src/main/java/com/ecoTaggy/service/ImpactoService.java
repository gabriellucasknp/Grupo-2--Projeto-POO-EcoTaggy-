package com.ecoTaggy.service;

import com.ecoTaggy.entity.ImpactoAmbiental;
import com.ecoTaggy.entity.Transacao;
import com.ecoTaggy.repository.ImpactoAmbientalRepository;
import com.ecoTaggy.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        impacto.setCombustivelEconomizado(volumeTransacoes * 0.01); 

        return impacto;
    }

    // 🔹 NOVO: Método de geração de Relatório ESG automatizado (Entrega 03)
    public Map<String, Object> gerarRelatorioESG() {
        // LER DO BANCO DE DADOS (Regra da faculdade)
        List<ImpactoAmbiental> todosImpactos = impactoRepository.findAll();

        double co2TotalEvitado = 0.0;
        double papelTotalEvitado = 0.0;
        double combustivelTotalPoupado = 0.0;

        // Somarizando os dados brutos usando os getters da sua entidade
        for (ImpactoAmbiental impacto : todosImpactos) {
            co2TotalEvitado += impacto.getCo2Evitado();
            papelTotalEvitado += impacto.getPapelEconomizado(); 
            combustivelTotalPoupado += impacto.getCombustivelEconomizado(); 
        }

        // Formatando a data padrão BR
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Montando o Dicionário/Map que será enviado para a tela (Thymeleaf)
        Map<String, Object> relatorio = new HashMap<>();
        relatorio.put("co2Total", String.format("%.2f", co2TotalEvitado));
        relatorio.put("papelTotal", String.format("%.2f", papelTotalEvitado));
        relatorio.put("combustivelTotal", String.format("%.2f", combustivelTotalPoupado));
        relatorio.put("transacoesAvaliadas", todosImpactos.size());
        relatorio.put("dataGeracao", LocalDate.now().format(formatter));
        relatorio.put("metodologia", "GHG Protocol (Escopo 3) - Otimização de Operações");

        return relatorio;
    }
}