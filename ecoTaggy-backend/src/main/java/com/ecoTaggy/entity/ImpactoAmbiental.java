package com.ecoTaggy.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_impacto_ambiental")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
