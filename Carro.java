package ExerciciosJava;// Crie uma classe Carro com métodos para representar um modelo específico
// ao longo de três anos. Implemente métodos para definir o nome do modelo,
// os preços médios para cada ano, e calcular e exibir o menor e o maior preço.
// Adicione uma subclasse ModeloCarro para criar instâncias específicas, utilizando-a
// na classe principal para definir preços e mostrar informações.

public class Carro {
    private String modelo;
    private double precoAno1;
    private double precoAno2;
    private double precoAno3;

    public void definirModelo(String modelo){
        this.modelo = modelo;
    }

    public void definirPrecos(double precoAno1, double precoAno2, double precoAno3){
        this.precoAno1 = precoAno1;
        this.precoAno2 = precoAno2;
        this.precoAno3 = precoAno3;
    }

    public void exibirInfo(){
        System.out.println("Modelo: " + modelo);
        System.out.println("Preço Ano 1: " + precoAno1);
        System.out.println("Preço Ano 2: " + precoAno2);
        System.out.println("Preço Ano 3: " + precoAno3);
        System.out.println("Menor Preço: " + calcularMenorPreco());
        System.out.println("Maior Preço: " + calcularMaiorPreco());
    }

    public double calcularMenorPreco(){
        double menorPreco = precoAno1;

        if (precoAno2 < menorPreco){
            menorPreco = precoAno2;
        }
        if (precoAno3 < menorPreco){
            menorPreco = precoAno3;
        }

        return menorPreco;
    }
    public double calcularMaiorPreco(){
        double maiorPreco = precoAno1;

        if (precoAno2 > maiorPreco){
            maiorPreco = precoAno2;
        }
        if (precoAno3 > maiorPreco){
            maiorPreco = precoAno3;
        }

        return maiorPreco;
    }
}

// Subclasse ModeloCarro
class ModeloCarro extends Carro {
    Carro car = new Carro();

}
// Classe de Teste
class TesteCarro {
    public static void main(String[] args) {
        ModeloCarro meuCarro = new ModeloCarro();
        meuCarro.definirModelo("Porscher");
        meuCarro.definirPrecos(500000, 4350000, 120000);
        meuCarro.exibirInfo();
    }
}
