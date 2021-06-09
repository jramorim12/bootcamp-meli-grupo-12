import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio01 {

    public static Scanner scanner = new Scanner(System.in);


    public static boolean finalizarLoop(int value){
        switch (value){
            case 1:
                return true;
            default:
                return false;
        }
    }

    public static void addEstudantes(ArrayList<Estudante> estudantes){
        boolean continuar = true;

        while(continuar){
            Estudante estudante = new Estudante();
            System.out.println("Insira o nome do aluno: ");
            estudante.setNome(scanner.next());
            System.out.println("Insira a idade do aluno: ");
            estudante.setIdade(scanner.nextInt());
            System.out.println("Insira o nome da matrícula do aluno: ");
            estudante.setnMatricula(scanner.nextLong());
            System.out.println("Insira a serie do aluno: ");
            estudante.setSerie(scanner.next());
            estudantes.add(estudante);
            System.out.println("Para inserir outro aluno digite 1 para sair digite 2: ");
            continuar = finalizarLoop(scanner.nextInt());
        }
    }

    public static void addDisciplinas(ArrayList<Disciplina> disciplinas){
        boolean continuar = true;
        while(continuar){
            Disciplina disciplina = new Disciplina();
            System.out.println("Insira o nome da disciplina: ");
            disciplina.setNome(scanner.next());
            System.out.println("Insira a carga horária da disciplina: ");
            disciplina.setCargaHoraria(scanner.nextInt());
            disciplinas.add(disciplina);
            System.out.println("Para inserir outra disciplina digite 1 para sair digite 2: ");
            continuar = finalizarLoop(scanner.nextInt());
        }
    }

    public static void addTurmas(ArrayList<Turma> turmas){
        boolean continuar = true;
        while(continuar){

            ArrayList<Estudante> estudantes = new ArrayList<>();
            ArrayList<Disciplina> disciplinas = new ArrayList<>();

            addEstudantes(estudantes);
            addDisciplinas(disciplinas);

            Turma turma = new Turma();
            System.out.println("Insira o nome da turma: ");
            turma.setNome(scanner.next());
            System.out.println("Insira o ID da turma: ");
            turma.setId(scanner.nextLong());
            turma.setDisciplinas(disciplinas);
            turma.setEstudantes(estudantes);
            turmas.add(turma);
            System.out.println("Para inserir outra turma digite 1 para sair digite 2: ");
            continuar = finalizarLoop(scanner.nextInt());
        }
    }

    public static void mostrarTurmas(ArrayList<Turma> turmas){
        for(Turma t: turmas){
            t.mostrarTurma();
        }
    }

    public static void main(String[] args) {
            ArrayList<Turma> turmas = new ArrayList<>();
            addTurmas(turmas);
            mostrarTurmas(turmas);
    }
}

