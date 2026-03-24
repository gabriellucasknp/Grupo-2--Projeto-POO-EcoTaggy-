package ecotagger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GerenciadorDeUsuarios {

    private final List<Usuario> usuarios = new ArrayList<>();

    public boolean adicionarUsuario(Usuario usuario) {
        if (buscarPorUsername(usuario.getUsername()).isPresent()) {
            return false;
        }
        usuarios.add(usuario);
        return true;
    }

    public Optional<Usuario> buscarPorUsername(String username) {
        return usuarios.stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }

    public boolean promoverParaAdmin(String username) {
        Optional<Usuario> encontrado = buscarPorUsername(username);
        if (encontrado.isPresent()) {
            encontrado.get().setPerfil(Perfil.ADMIN);
            return true;
        }
        return false;
    }

    public List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios);
    }
}
