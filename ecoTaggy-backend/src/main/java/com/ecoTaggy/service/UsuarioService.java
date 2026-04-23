package com.ecoTaggy.service;


import com.ecoTaggy.entity.ImpactoAmbiental;
import com.ecoTaggy.entity.Usuario;
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
        // 1. Busca o usuário
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + id));


        // 2. Atualiza o nome
        if (novoNome != null && !novoNome.trim().isEmpty()) {
            usuario.setNome(novoNome);
        }


        // 3. Lógica para transformar o arquivo em String Base64 funcional
        if (arquivo != null && !arquivo.isEmpty()) {
            try {
                byte[] bytes = arquivo.getBytes();
                String base64String = Base64.getEncoder().encodeToString(bytes);
                
                String fotoUrlFinal = "data:" + arquivo.getContentType() + ";base64," + base64String;
                usuario.setFotoUrl(fotoUrlFinal);
                
            } catch (IOException e) {
                throw new RuntimeException("Erro ao processar a imagem: " + e.getMessage());
            }
        }


        // 4. Atualiza a senha (se preenchida)
        if (novaSenha != null && !novaSenha.trim().isEmpty()) {
            usuario.setSenha(novaSenha);
        }


        // 5. Salva as alterações
        usuarioRepository.save(usuario);
    }


    // --- Outros métodos permanecem iguais ---
    
    public Usuario cadastrarUsuario(Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new RuntimeException("Este e-mail já está em uso!");
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


    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + id));
    }
}


