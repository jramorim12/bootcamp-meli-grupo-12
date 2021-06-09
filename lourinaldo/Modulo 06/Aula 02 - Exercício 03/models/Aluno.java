package com.Aula08Modulo06Exercicio01.demo.models;

import java.util.ArrayList;

public class Aluno {
    private String nome;
    private ArrayList<disciplina> disciplinas;

    public Aluno(String nome, ArrayList<disciplina> disciplinas) {
        this.nome = nome;
        this.disciplinas = disciplinas;
    }

    public Aluno() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public double media(){
        return this.disciplinas.stream().mapToDouble(a -> a.getNota()).average().getAsDouble();
    }

    public String mensagem(){
        Double media = this.media();
        String msg = "";
        if(media > 9){
            msg = "Sua média eh "+media+". Parabéns!!";
        }else if(media > 7){
            msg = "Sua média eh "+media;
        }else{
            msg = "Sua média eh "+media+". Você foi reprovado.";
        }

        return msg;
    }
}
