package ExerciciosJava;

public class Animal {
    public void emitirSom(){
        System.out.println("Som do Animal");
    }

}
//Subclasse
class Cachorro extends Animal{
    @Override
    public void emitirSom() {
        System.out.println("AU AU");
    }
    public void abanarRabo() {
        System.out.println("Cachorro abanando o rabo");
    }
}
class Gato extends Animal{
    @Override
    public void emitirSom(){
        System.out.println("\nMiau ");
    }

    public void arranharMoveis(){
        System.out.println("Gato está arranhar os Moveis");
    }
}
class TestaAnimais{
    public static void main(String[] args) {
        Cachorro dog = new Cachorro();
        dog.emitirSom();
        dog.abanarRabo();

        Gato cat = new Gato();
        cat.emitirSom();
        cat.arranharMoveis();
    }
}


