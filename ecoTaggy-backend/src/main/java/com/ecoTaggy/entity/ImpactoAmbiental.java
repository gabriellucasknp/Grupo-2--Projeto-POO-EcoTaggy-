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
