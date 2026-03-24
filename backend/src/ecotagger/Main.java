package ecotagger;

public class Main {

    public static void main(String[] args) {
        GerenciadorDeUsuarios gerenciador = new GerenciadorDeUsuarios();

        // Cadastro dos colaboradores da equipe
        gerenciador.adicionarUsuario(new Usuario("davidgsa",  "David Guilherme Souza Alves",    "david@ecotagger.com",   Perfil.COLABORADOR));
        gerenciador.adicionarUsuario(new Usuario("diegoja",   "Diego José Arroxelas",            "diego@ecotagger.com",   Perfil.COLABORADOR));
        gerenciador.adicionarUsuario(new Usuario("joaogabriel","João Gabriel de Souza Neri",     "joao@ecotagger.com",    Perfil.COLABORADOR));
        gerenciador.adicionarUsuario(new Usuario("rafaelaa",  "Rafael de Andrade Arruda",        "rafael@ecotagger.com",  Perfil.COLABORADOR));
        gerenciador.adicionarUsuario(new Usuario("m4paulo",   "Matheus Paulo dos Santos Silva",  "matheus@ecotagger.com", Perfil.COLABORADOR));
        gerenciador.adicionarUsuario(new Usuario("pedropb",   "Pedro Pessoa Bastos",             "pedro@ecotagger.com",   Perfil.COLABORADOR));
        gerenciador.adicionarUsuario(new Usuario("gabriellucas","Gabriel Lucas Soares da Silva", "gabriel@ecotagger.com", Perfil.COLABORADOR));

        System.out.println("=== Usuários antes da promoção ===");
        gerenciador.listarUsuarios().forEach(System.out::println);

        // Promover m4paulo a admin
        boolean promovido = gerenciador.promoverParaAdmin("m4paulo");
        if (promovido) {
            System.out.println("\nm4paulo foi promovido a ADMIN com sucesso!");
        } else {
            System.out.println("\nUsuário m4paulo não encontrado.");
        }

        System.out.println("\n=== Usuários após a promoção ===");
        gerenciador.listarUsuarios().forEach(System.out::println);
    }
}
