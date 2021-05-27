package com.Aula08Modulo06Exercicio01.demo.models;

public class disciplina {
    private String nome;
    private Double nota;

    public disciplina(String nome, Double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public disciplina() { }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}
