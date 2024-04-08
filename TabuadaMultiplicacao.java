interface Tabuada{
    void mostrarTabuada(int numero);
}

public class TabuadaMultiplicacao implements Tabuada {

    @Override
    public void mostrarTabuada(int numero) {
        for (int i=1; i <= 10; i++){
            int resultado = numero * i;
            System.out.println(numero+"x"+i+"="+resultado);
        }
    }
}

class TesteDaTabuada{
    public static void main(String[] args) {
       TabuadaMultiplicacao tabuada = new TabuadaMultiplicacao();

       tabuada.mostrarTabuada(5);
    }
}
