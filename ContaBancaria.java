// Crie uma classe ContaBancaria com métodos para realizar
// operações bancárias como depositar(), sacar() e consultarSaldo().
// Em seguida, crie uma subclasse ContaCorrente que herda da
// classe ContaBancaria. Adicione um método específico para a subclasse,
// como cobrarTarifaMensal(), que desconta uma tarifa mensal da conta corrente.

public class ContaBancaria {
    protected double saldo;

    public void depositar(double valor){
        saldo += valor;
        System.out.println("Depósito de "+ valor +" realizado. Saldo atual: "+saldo);
    }
    public void sacar(double valor){
        if (valor <= saldo){
            saldo -= valor;
            System.out.println("Saque de "+ saldo+ " realizado. Saldo atual: "+ saldo);
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    public void consultarSaldo(){
        System.out.println("Saldo atual: "+  saldo);
    }
}
// Subclasse ContaCorrente
class ContaCorrente extends ContaBancaria{
    private double tarifaMensal;

    public void cobrarTarifaMensal(){
        saldo -= tarifaMensal;
        System.out.println("Tarifa mensal de "+ tarifaMensal+ " cobrada. Saldo atual: "+ saldo);
    }
}

// Classe Teste
class TesteContaBancaria{
    public static void main(String[] args) {
        //Criando uma conta bancária com saldo inicial de 1000
        ContaBancaria conta = new ContaBancaria();
        conta.depositar(1000);
        conta.consultarSaldo();

        //Realizando operações na conta corrente
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.depositar(200);
        contaCorrente.cobrarTarifaMensal();
        contaCorrente.consultarSaldo();
        contaCorrente.sacar(150);
        contaCorrente.consultarSaldo();

    }
}



