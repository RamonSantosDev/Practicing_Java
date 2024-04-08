package ExerciciosJava;

public class Produto {
    private String nome;
    private double preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void aplicarDesconto(double percentual){
        double desconto = preco * (percentual/100);
        this.preco -= desconto;

    }

    public void exibeCompra() {
        System.out.println("Produto: " + getNome());
        System.out.println("Preço: " + getPreco());
    }
}


