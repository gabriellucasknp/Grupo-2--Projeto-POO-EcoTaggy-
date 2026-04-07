package com.ecoTaggy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_impacto_ambiental")
public class ImpactoAmbiental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double co2Evitado;
    private double papelEconomizado;
    private double combustivelSalvo;

    @OneToOne
    @JoinColumn(name = "transacao_id")
    private Transacao transacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getCo2Evitado() {
        return co2Evitado;
    }

    public void setCo2Evitado(double co2Evitado) {
        this.co2Evitado = co2Evitado;
    }

    public double getPapelEconomizado() {
        return papelEconomizado;
    }

    public void setPapelEconomizado(double papelEconomizado) {
        this.papelEconomizado = papelEconomizado;
    }

    public double getCombustivelSalvo() {
        return combustivelSalvo;
    }

    public void setCombustivelSalvo(double combustivelSalvo) {
        this.combustivelSalvo = combustivelSalvo;
    }

    public Transacao getTransacao() {
        return transacao;
    }

    public void setTransacao(Transacao transacao) {
        this.transacao = transacao;
    }

    @Override
    public String toString() {
        return "ImpactoAmbiental{" +
                "id=" + id +
                ", co2Evitado=" + co2Evitado +
                ", papelEconomizado=" + papelEconomizado +
                ", combustivelSalvo=" + combustivelSalvo +
                '}';
    }
}
