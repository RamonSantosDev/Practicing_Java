package ExerciciosJava;

class DadosAluno{
    String nome;
    int idade;


    void fichaDoAluno(){
        System.out.println("Nome do aluno: "+nome);
        System.out.println("Idade: "+idade);
    }
}


class Aluno {
    public static void main(String[] args) {
        DadosAluno student = new DadosAluno();
        student.idade=12;
        student.nome="Bruno";

        student.fichaDoAluno();
    }
}
