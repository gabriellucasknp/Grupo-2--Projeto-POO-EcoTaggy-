package com.ecoTaggy.entity;


import jakarta.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "tb_papel_economizado")
public class PapelEconomizado {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // A proteção anti-null no banco e no Java
    @Column(name = "quantidade_folhas", nullable = false)
    private Integer quantidadeFolhas = 0; 


    @Column(name = "gramatura_media", nullable = false)
    private Double gramaturaMedia = 75.0;


    @Column(name = "data_registro", nullable = false)
    private LocalDateTime dataRegistro = LocalDateTime.now();


    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;


    public PapelEconomizado() {}


    // GETTERS E SETTERS - O Hibernate precisa destes para evitar o PropertyAccessException
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }


    public Integer getQuantidadeFolhas() { return quantidadeFolhas; }
    public void setQuantidadeFolhas(Integer quantidadeFolhas) { 
        this.quantidadeFolhas = (quantidadeFolhas != null) ? quantidadeFolhas : 0; 
    }


    public Double getGramaturaMedia() { return gramaturaMedia; }
    public void setGramaturaMedia(Double gramaturaMedia) { this.gramaturaMedia = gramaturaMedia; }


    public LocalDateTime getDataRegistro() { return dataRegistro; }
    public void setDataRegistro(LocalDateTime dataRegistro) { this.dataRegistro = dataRegistro; }


    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}




