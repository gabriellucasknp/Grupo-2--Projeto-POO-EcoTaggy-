package com.ecotaggy.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "impactos_ambientais")
public class ImpactoAmbiental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "transacao_id", nullable = false)
    private Transacao transacao;

    /**
     * CO₂ economizado em kg — calculado com base no tempo parado evitado
     * na cabine de pedágio pelo uso do pagamento digital via Taggy.
     */
    @Column(nullable = false)
    private Double co2Economizado;

    /**
     * Combustível economizado em litros pelo não-idling na praça de pedágio.
     */
    @Column(nullable = false)
    private Double combustivelEconomizado;

    /**
     * Tempo poupado em minutos por não aguardar na fila do pedágio.
     */
    @Column(nullable = false)
    private Double tempoPoupado;

    @Column(nullable = false)
    private LocalDateTime dataCalculo;

    private String descricao;

    public ImpactoAmbiental() {
    }

    public ImpactoAmbiental(Transacao transacao, Double co2Economizado,
        Double combustivelEconomizado, Double tempoPoupado,
        LocalDateTime dataCalculo, String descricao) {
        this.transacao = transacao;
        this.co2Economizado = co2Economizado;
        this.combustivelEconomizado = combustivelEconomizado;
        this.tempoPoupado = tempoPoupado;
        this.dataCalculo = dataCalculo;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Transacao getTransacao() {
        return transacao;
    }

    public void setTransacao(Transacao transacao) {
        this.transacao = transacao;
    }

    public Double getCo2Economizado() {
        return co2Economizado;
    }

    public void setCo2Economizado(Double co2Economizado) {
        this.co2Economizado = co2Economizado;
    }

    public Double getCombustivelEconomizado() {
        return combustivelEconomizado;
    }

    public void setCombustivelEconomizado(Double combustivelEconomizado) {
        this.combustivelEconomizado = combustivelEconomizado;
    }

    public Double getTempoPoupado() {
        return tempoPoupado;
    }

    public void setTempoPoupado(Double tempoPoupado) {
        this.tempoPoupado = tempoPoupado;
    }

    public LocalDateTime getDataCalculo() {
        return dataCalculo;
    }

    public void setDataCalculo(LocalDateTime dataCalculo) {
        this.dataCalculo = dataCalculo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
