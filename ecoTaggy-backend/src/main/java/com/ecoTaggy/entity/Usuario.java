package com.ecoTaggy.entity;

import jakarta.persistence.*;
import java.util.ArrayList; // Importante!
import java.util.List;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private ImpactoAmbiental impacto;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Transacao> transacoes = new ArrayList<>();

    public Usuario() {}

    // Construtor atualizado com Perfil e Impacto
    public Usuario(Long id, String nome, String email, Perfil perfil, ImpactoAmbiental impacto, List<Transacao> transacoes) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.perfil = perfil;
        this.impacto = impacto;
        this.transacoes = transacoes;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    
    // Novos Getters e Setters
    public Perfil getPerfil() { return perfil; }
    public void setPerfil(Perfil perfil) { this.perfil = perfil; }
    public ImpactoAmbiental getImpacto() { return impacto; }
    public void setImpacto(ImpactoAmbiental impacto) { this.impacto = impacto; }

    public List<Transacao> getTransacoes() { return transacoes; }
    public void setTransacoes(List<Transacao> transacoes) { this.transacoes = transacoes; }

    @Override
    public String toString() {
        return "Usuario{id=" + id + ", nome='" + nome + "', email='" + email + "', perfil=" + perfil + "}";
    }

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String fotoUrl;
    private String senha;

    public String getFotoUrl() { return fotoUrl; }
    public void setFotoUrl(String fotoUrl) { this.fotoUrl = fotoUrl; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}