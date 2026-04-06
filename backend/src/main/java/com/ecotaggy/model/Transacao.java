package com.ecotaggy.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transacoes")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(nullable = false)
    private String localPedagio;

    @Column(nullable = false)
    private String tipoVeiculo;

    @OneToOne(mappedBy = "transacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private ImpactoAmbiental impactoAmbiental;

    public Transacao() {
    }

    public Transacao(Usuario usuario, LocalDateTime dataHora, BigDecimal valor,
                     String localPedagio, String tipoVeiculo) {
        this.usuario = usuario;
        this.dataHora = dataHora;
        this.valor = valor;
        this.localPedagio = localPedagio;
        this.tipoVeiculo = tipoVeiculo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getLocalPedagio() {
        return localPedagio;
    }

    public void setLocalPedagio(String localPedagio) {
        this.localPedagio = localPedagio;
    }

    public String getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(String tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public ImpactoAmbiental getImpactoAmbiental() {
        return impactoAmbiental;
    }

    public void setImpactoAmbiental(ImpactoAmbiental impactoAmbiental) {
        this.impactoAmbiental = impactoAmbiental;
    }
}
