import java.util.ArrayList;
import java.util.Scanner;

// Classe Peca
class Peca {
    private String nome;
    private int quantidade;

    public Peca(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

// Classe Estoque
class Estoque {
    private ArrayList<Peca> pecas = new ArrayList<>();

    public void adicionarPeca(Peca peca) {
        for (Peca p : pecas) {
            if (p.getNome().equals(peca.getNome())) {
                p.setQuantidade(p.getQuantidade() + peca.getQuantidade());
                return;
            }
        }
        pecas.add(peca);
    }

    public void removerPeca(Peca peca) {
        String nome = peca.getNome();
        int quantidade = peca.getQuantidade();
        for (Peca p : pecas) {
            if (p.getNome().equals(nome)) {
                int novaQuantidade = p.getQuantidade() - quantidade;
                if (novaQuantidade >= 0) {
                    p.setQuantidade(novaQuantidade);
                } else {
                    System.out.println("Não é possível remover mais peças do que existem no estoque.");
                }
                return;
            }
        }
        System.out.println("Peça não encontrada no estoque.");
    }

    public void mostrarEstoque() {
        System.out.println("=== Lista do Estoque ===");
        for (Peca p : pecas) {
            System.out.println(p.getNome() + ": " + p.getQuantidade());
        }
    }
}

// Classe Usuário
class Usuario {
    private String nome;
    private String senha;

    public Usuario(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public boolean autenticar(String nome, String senha) {
        return this.nome.equals(nome) && this.senha.equals(senha);
    }
}

// Classe Administrador
class Administrador extends Usuario {
    public Administrador(String nome, String senha) {
        super(nome, senha);
    }

    public void manipularEstoque(Estoque estoque) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha a operação:");
        System.out.println("1 - Adicionar peça");
        System.out.println("2 - Remover peça");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        switch (escolha) {
            case 1:
                adicionarPeca(estoque);
                break;
            case 2:
                removerPeca(estoque);
                break;
            default:
                System.out.println("Opção inválida.");
        }
        scanner.close();
    }

    private void adicionarPeca(Estoque estoque) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome da peça:");
        String nome = scanner.nextLine();
        System.out.println("Digite a quantidade:");
        int quantidade = scanner.nextInt();
        estoque.adicionarPeca(new Peca(nome, quantidade));
    }

    private void removerPeca(Estoque estoque) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome da peça:");
        String nome = scanner.nextLine();
        System.out.println("Digite a quantidade:");
        int quantidade = scanner.nextInt();
        Peca peca = new Peca(nome, quantidade); // Criar objeto Peca
        estoque.removerPeca(peca); // Passar objeto Peca para removerPeca
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criar instâncias de Estoque e Usuário
        Estoque estoque = new Estoque();
        Usuario usuario = new Usuario("root", "toor");

        // Realizar operações de adição e remoção no estoque
        estoque.adicionarPeca(new Peca("Parafuso", 100));
        estoque.adicionarPeca(new Peca("Porca", 50));
        estoque.adicionarPeca(new Peca("Corda",25));
        estoque.mostrarEstoque();

        System.out.println("\nDigite seu nome de usuário:");
        String nomeUsuario = scanner.nextLine();
        System.out.println("Digite sua senha:");
        String senha = scanner.nextLine();

        // Autenticar o usuário
        if (usuario.autenticar(nomeUsuario, senha)) {
            System.out.println("Usuário autenticado com sucesso!");

            // Adicionar e remover peças
            System.out.println("\nDigite o nome da peça a adicionar:");
            String nomePeca = scanner.nextLine();
            System.out.println("Digite a quantidade da peça a adicionar:");
            int quantidadePeca = scanner.nextInt();
            estoque.adicionarPeca(new Peca(nomePeca, quantidadePeca));
            scanner.nextLine(); // Limpar o buffer do scanner

            while (true) {
                System.out.println("\nDeseja remover uma peça? (Digite 'sim' ou 'nao'):");
                String resposta = scanner.nextLine().toLowerCase();
                if (resposta.equals("sim")) {
                    System.out.println("Digite o nome da peça a remover:");
                    nomePeca = scanner.nextLine();
                    System.out.println("Digite a quantidade da peça a remover:");
                    int quantidadeRemover = scanner.nextInt();
                    Peca pecaRemover = new Peca(nomePeca, quantidadeRemover); // Criar um objeto Peca
                    estoque.removerPeca(pecaRemover); // Remover a peça
                    scanner.nextLine(); // Limpar o buffer do scanner
                } else if (resposta.equals("nao")) {
                    break; // Sai do loop se o usuário não desejar mais remover peças
                } else {
                    System.out.println("Resposta inválida. Por favor, digite 'sim' ou 'nao'.");
                }
            }
        } else {
            System.out.println("Usuário ou senha incorretos. Encerrando o programa.");
            return;
        }

        // Apresentar as informações do estoque atualizadas e o usuário que está logado
        estoque.mostrarEstoque();

        scanner.close();
    }
}