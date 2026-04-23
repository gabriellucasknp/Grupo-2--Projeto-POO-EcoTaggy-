package com.ecoTaggy.service;


import com.ecoTaggy.entity.ImpactoAmbiental;
import com.ecoTaggy.entity.Usuario;
import com.ecoTaggy.repository.ImpactoAmbientalRepository;
import com.ecoTaggy.repository.TransacaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ImpactoService {


    private final ImpactoAmbientalRepository impactoRepository;
    private final TransacaoRepository transacaoRepository;


    public ImpactoService(ImpactoAmbientalRepository impactoRepository, TransacaoRepository transacaoRepository) {
        this.impactoRepository = impactoRepository;
        this.transacaoRepository = transacaoRepository;
    }


    /**
     * 🔹 MÉTODO DE SIMULAÇÃO: Necessário para o ImpactoController compilar.
     * Não salva no banco, apenas retorna um cálculo temporário.
     */
    public ImpactoAmbiental simularImpacto(int volumeTransacoes) {
        ImpactoAmbiental simulado = new ImpactoAmbiental();
        
        // Mantendo os mesmos coeficientes científicos do real
        simulado.setCo2Evitado(volumeTransacoes * 0.150);
        simulado.setPapelEconomizado(volumeTransacoes * 0.001);
        simulado.setCombustivelEconomizado(volumeTransacoes * 0.050);
        simulado.setTransacoesProcessadas(volumeTransacoes);
        
        return simulado;
    }


    /**
     * 🔹 MÉTODO REAL: Processa o impacto de uma nova passagem.
     * Acumula o valor real no histórico do usuário e persiste no banco.
     */
    @Transactional
    public ImpactoAmbiental registrarPassagemReal(Usuario usuario, String tipoOperacao) {
        // Busca impacto existente ou cria um novo vinculado ao usuário
        ImpactoAmbiental impacto = impactoRepository.findByUsuario(usuario)
                .orElse(new ImpactoAmbiental(usuario));


        // 📊 Coeficientes Reais (Baseados em economia por evitar inércia/marcha lenta)
        double fatorCO2 = tipoOperacao.equalsIgnoreCase("PEDAGIO") ? 0.150 : 0.080;
        double fatorCombustivel = tipoOperacao.equalsIgnoreCase("PEDAGIO") ? 0.050 : 0.020;
        double fatorPapel = 0.001; // 1 ticket evitado


        // Acumulação Real
        impacto.setCo2Evitado(impacto.getCo2Evitado() + fatorCO2);
        impacto.setCombustivelEconomizado(impacto.getCombustivelEconomizado() + fatorCombustivel);
        impacto.setPapelEconomizado(impacto.getPapelEconomizado() + fatorPapel);
        impacto.setTransacoesProcessadas(impacto.getTransacoesProcessadas() + 1);


        return impactoRepository.save(impacto);
    }


    /**
     * 🔹 RELATÓRIO ESG CONSOLIDADO (Entrega 03)
     */
    public Map<String, Object> gerarRelatorioESG() {
        List<ImpactoAmbiental> todosImpactos = impactoRepository.findAll();


        double co2TotalEvitado = 0.0;
        double papelTotalEvitado = 0.0;
        double combustivelTotalPoupado = 0.0;
        long totalTransacoes = 0;


        for (ImpactoAmbiental impacto : todosImpactos) {
            co2TotalEvitado += impacto.getCo2Evitado();
            papelTotalEvitado += impacto.getPapelEconomizado();
            combustivelTotalPoupado += impacto.getCombustivelEconomizado();
            totalTransacoes += impacto.getTransacoesProcessadas();
        }


        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        Map<String, Object> relatorio = new HashMap<>();
        relatorio.put("co2Total", String.format("%.3f", co2TotalEvitado));
        relatorio.put("papelTotal", String.format("%.3f", papelTotalEvitado));
        relatorio.put("combustivelTotal", String.format("%.3f", combustivelTotalPoupado));
        relatorio.put("transacoesAvaliadas", totalTransacoes);
        relatorio.put("dataGeracao", LocalDate.now().format(formatter));
        relatorio.put("metodologia", "GHG Protocol & CETESB - Fatores de Emissão para Veículos Leves");


        return relatorio;
    }
}




