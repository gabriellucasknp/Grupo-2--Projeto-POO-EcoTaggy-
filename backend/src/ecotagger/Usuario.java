package ecotagger;

public class Usuario {

    private String username;
    private String nome;
    private String email;
    private Perfil perfil;

    public Usuario(String username, String nome, String email, Perfil perfil) {
        this.username = username.toLowerCase();
        this.nome = nome;
        this.email = email;
        this.perfil = perfil;
    }

    public String getUsername() {
        return username;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public boolean isAdmin() {
        return perfil == Perfil.ADMIN;
    }

    @Override
    public String toString() {
        return "Usuario{username='" + username + "', nome='" + nome + "', perfil=" + perfil + "}";
    }
}
