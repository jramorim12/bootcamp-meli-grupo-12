package com.Aula08Modulo06Exercicio01.demo.dtos;

public class ComodoDTO {
    private String nome;
    private double area;

    public ComodoDTO(String nome, double area) {
        this.nome = nome;
        this.area = area;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
