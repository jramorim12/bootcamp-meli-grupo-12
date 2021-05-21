package entidades;

import java.util.ArrayList;
import java.util.Arrays;

public class Turma {

    private Serie serie;
    private String id;
    private Aluno[] alunos;
    private Disciplina[] disciplinas;

    public Turma(Serie serie, String id, Aluno[] alunos, Disciplina[] disciplinas) {
        this.serie = serie;
        this.id = id;
        this.alunos = alunos;
        this.disciplinas = disciplinas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno[] alunos) {
        this.alunos = alunos;
    }

    public Disciplina[] getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Disciplina[] disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {
        return "Turma: " + this.serie + " " + this.id + "\n"
               + "Alunos: " + Arrays.toString(this.alunos) + "\n"
               + "Disciplinas: " + Arrays.toString(this.disciplinas);
    }
}
