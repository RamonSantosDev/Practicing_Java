package ExerciciosJava;

public class idadePesssoa {
    private String nome;
    private int idade;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void exibeInfoPessoa() {
        System.out.println("Nome da Pessoa:" + getNome());
        System.out.println("Idade: " + getIdade());
    }

    public void verificarIdade(int idade){
        if(idade>=18){
            System.out.println("Essa pessoa é de maior.");;
        } else {
            System.out.println("Essa pessoa é menor");
        }
    }
}
