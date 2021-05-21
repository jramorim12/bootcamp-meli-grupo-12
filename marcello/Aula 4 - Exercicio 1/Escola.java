import entidades.*;

import java.util.*;

public class Escola {

    public static void main(String[] args) {
        List<Turma> turmasDaEscola = Escola.initEscola();
        Escola.mostraEscola(turmasDaEscola);
    }

    private static List<Turma> initEscola() {

        Serie primeiroMedio = new Serie(1, Grau.MEDIO);
        Serie segundoMedio = new Serie(2, Grau.MEDIO);
        Serie terceiroMedio = new Serie(3, Grau.MEDIO);
        Serie nonoAno = new Serie(9, Grau.FUNDAMENTAL);

        Disciplina matematica = new Disciplina("Matemática", 80);
        Disciplina geografia = new Disciplina("Geografia", 40);
        Disciplina historia = new Disciplina("História", 40);
        Disciplina portugues = new Disciplina("Língua Portuguesa", 80);

        Disciplina[] disciplinas = {matematica, geografia, historia, portugues};

        Aluno joao = new Aluno("João",15, 625, primeiroMedio);
        Aluno rodrigo = new Aluno("Rodrigo", 16, 52, segundoMedio);
        Aluno beatriz = new Aluno("Beatriz", 17, 93, terceiroMedio);
        Aluno maria = new Aluno("Maria", 14, 686, nonoAno);
        Aluno natalia = new Aluno("Natalia", 15, 923, primeiroMedio);
        Aluno leticia = new Aluno("Leticia", 17, 199, terceiroMedio);

        Turma primeiroMedioA = new Turma(primeiroMedio, "A", new Aluno[]{joao, natalia}, disciplinas);
        Turma segundoMedioA = new Turma(segundoMedio, "A", new Aluno[]{rodrigo}, disciplinas);
        Turma terceiroMedioB = new Turma(terceiroMedio, "B", new Aluno[]{beatriz, leticia}, disciplinas);
        Turma nonoAnoC = new Turma(nonoAno, "C", new Aluno[]{maria}, disciplinas);

        List<Turma> turmasDaEscola = new ArrayList<>();

        turmasDaEscola.add(primeiroMedioA);
        turmasDaEscola.add(segundoMedioA);
        turmasDaEscola.add(terceiroMedioB);
        turmasDaEscola.add(nonoAnoC);

        return turmasDaEscola;

    }

    private static void mostraEscola(List<Turma> turmasDaEscola) {

        for(Turma turma : turmasDaEscola) {
            System.out.println(turma);
        }

    }

}
