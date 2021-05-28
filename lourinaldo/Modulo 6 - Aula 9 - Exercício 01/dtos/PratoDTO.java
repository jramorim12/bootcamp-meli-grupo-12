package com.Aula08Modulo06Exercicio01.demo.dtos;

import java.util.ArrayList;

public class PratoDTO {
    String nome;
    ArrayList<String> ingredientes;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
