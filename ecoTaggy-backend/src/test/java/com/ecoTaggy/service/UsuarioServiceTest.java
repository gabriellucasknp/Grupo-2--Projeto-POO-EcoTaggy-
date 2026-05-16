package com.ecoTaggy.service;

import com.ecoTaggy.entity.Usuario;
import com.ecoTaggy.exception.DuplicateEmailException;
import com.ecoTaggy.exception.UserNotFoundException;
import com.ecoTaggy.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    void cadastrarUsuarioQuandoEmailJaExisteLancaExcecaoEspecifica() {
        Usuario usuario = new Usuario();
        usuario.setEmail("teste@ecotaggy.com");

        when(usuarioRepository.findByEmail(usuario.getEmail())).thenReturn(Optional.of(new Usuario()));

        assertThrows(DuplicateEmailException.class, () -> usuarioService.cadastrarUsuario(usuario));
    }

    @Test
    void cadastrarUsuarioInicializaImpactoAmbiental() {
        Usuario usuario = new Usuario();
        usuario.setEmail("novo@ecotaggy.com");

        when(usuarioRepository.findByEmail(usuario.getEmail())).thenReturn(Optional.empty());
        when(usuarioRepository.save(any(Usuario.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Usuario salvo = usuarioService.cadastrarUsuario(usuario);

        assertNotNull(salvo.getImpacto());
        assertEquals(0.0, salvo.getImpacto().getCo2Evitado());
        assertEquals(0.0, salvo.getImpacto().getPapelEconomizado());
        assertEquals(0.0, salvo.getImpacto().getCombustivelEconomizado());
        assertEquals(0, salvo.getImpacto().getTransacoesProcessadas());
        assertSame(salvo, salvo.getImpacto().getUsuario());
    }

    @Test
    void buscarPorIdQuandoNaoExisteLancaExcecaoEspecifica() {
        when(usuarioRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class, () -> usuarioService.buscarPorId(99L));
    }
}
