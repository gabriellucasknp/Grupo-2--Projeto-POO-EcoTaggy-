package com.ecoTaggy.service;


import com.ecoTaggy.entity.ImpactoAmbiental;
import com.ecoTaggy.entity.Usuario;
import com.ecoTaggy.exception.DuplicateEmailException;
import com.ecoTaggy.exception.ProfileImageProcessingException;
import com.ecoTaggy.exception.UserNotFoundException;
import com.ecoTaggy.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;
import java.util.Optional;


@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepository usuarioRepository;


    @Transactional
    public void atualizarPerfil(Long id, String novoNome, String novaSenha, MultipartFile arquivo) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));


        if (novoNome != null && !novoNome.trim().isEmpty()) {
            usuario.setNome(novoNome);
        }


        if (arquivo != null && !arquivo.isEmpty()) {
            try {
                byte[] bytes = arquivo.getBytes();
                String base64String = Base64.getEncoder().encodeToString(bytes);
                
                String fotoUrlFinal = "data:" + arquivo.getContentType() + ";base64," + base64String;
                usuario.setFotoUrl(fotoUrlFinal);
                
            } catch (IOException e) {
                throw new ProfileImageProcessingException("Erro ao processar a imagem do perfil.", e);
            }
        }


        if (novaSenha != null && !novaSenha.trim().isEmpty()) {
            usuario.setSenha(novaSenha);
        }


        usuarioRepository.save(usuario);
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new DuplicateEmailException("Este e-mail já está em uso!");
        }


        ImpactoAmbiental impactoInicial = new ImpactoAmbiental();
        impactoInicial.setCo2Evitado(0.0);
        impactoInicial.setPapelEconomizado(0.0);
        impactoInicial.setCombustivelEconomizado(0.0);
        impactoInicial.setTransacoesProcessadas(0);
       
        impactoInicial.setUsuario(usuario);
        usuario.setImpacto(impactoInicial);


        return usuarioRepository.save(usuario);
    }


    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Optional<Usuario> buscarPorIdOptional(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }
}


