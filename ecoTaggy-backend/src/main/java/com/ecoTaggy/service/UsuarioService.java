package com.ecoTaggy.service;

import com.ecoTaggy.entity.ImpactoAmbiental;
import com.ecoTaggy.entity.Usuario;
import com.ecoTaggy.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario cadastrarUsuario(Usuario usuario) {
        // 1. Verifica se o e-mail já está cadastrado
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new RuntimeException("Este e-mail já está em uso!");
        }

        // 2. Cria um impacto ambiental inicial zerado para o novo usuário
        ImpactoAmbiental impactoInicial = new ImpactoAmbiental();
        impactoInicial.setCo2Evitado(0.0);
        impactoInicial.setPapelEconomizado(0.0);
        impactoInicial.setCombustivelEconomizado(0.0);
        impactoInicial.setTransacoesProcessadas(0);
        
        // 3. Vincula o impacto ao usuário (Relacionamento Bidirecional)
        impactoInicial.setUsuario(usuario);
        usuario.setImpacto(impactoInicial);

        // 4. Salva o usuário (o CascadeType.ALL que colocamos na Entity vai salvar o impacto junto)
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }
}