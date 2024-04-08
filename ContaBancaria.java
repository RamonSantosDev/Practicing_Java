package ExerciciosJava;

public class ContaBancaria {

    private int numeroConta;
    private double saldo;
    public String titular;

    public void setNumeroConta(int numeroConta){
        this.numeroConta = numeroConta;
    }
    public int getNumeroConta(){
        return numeroConta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public double getSaldo() {
        return saldo;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getTitular() {
        return titular;
    }

    public void exibeContaBancaria() {
        System.out.println("Número da conta: " + getNumeroConta());
        System.out.println("Titular: " + getTitular());
        System.out.println("Saldo: " + getSaldo());
    }
}

