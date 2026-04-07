package com.ecoTaggy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_impacto")
public class ImpactoAmbiental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer transacoesProcessadas;
    private Double co2Evitado;
    private Double papelEconomizado;
    private Double combustivelEconomizado;

    public ImpactoAmbiental() {}

    public ImpactoAmbiental(Long id, Integer transacoesProcessadas, Double co2Evitado, Double papelEconomizado, Double combustivelEconomizado) {
        this.id = id;
        this.transacoesProcessadas = transacoesProcessadas;
        this.co2Evitado = co2Evitado;
        this.papelEconomizado = papelEconomizado;
        this.combustivelEconomizado = combustivelEconomizado;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Integer getTransacoesProcessadas() { return transacoesProcessadas; }
    public void setTransacoesProcessadas(Integer transacoesProcessadas) { this.transacoesProcessadas = transacoesProcessadas; }
    public Double getCo2Evitado() { return co2Evitado; }
    public void setCo2Evitado(Double co2Evitado) { this.co2Evitado = co2Evitado; }
    public Double getPapelEconomizado() { return papelEconomizado; }
    public void setPapelEconomizado(Double papelEconomizado) { this.papelEconomizado = papelEconomizado; }
    public Double getCombustivelEconomizado() { return combustivelEconomizado; }
    public void setCombustivelEconomizado(Double combustivelEconomizado) { this.combustivelEconomizado = combustivelEconomizado; }

    @Override
    public String toString() {
        return "ImpactoAmbiental{id=" + id + ", co2=" + co2Evitado + ", papel=" + papelEconomizado + "}";
    }
}