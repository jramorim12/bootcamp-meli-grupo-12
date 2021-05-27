package com.Aula08Modulo06Exercicio01.demo.models;

import com.Aula08Modulo06Exercicio01.demo.dtos.ComodoDTO;

import java.util.ArrayList;
import java.util.Comparator;

public class Casa {
    private String nome;
    private String endereco;
    private ArrayList<Comodo> comodos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Comodo> getComodos() {
        return comodos;
    }

    public void setComodos(ArrayList<Comodo> comodos) {
        this.comodos = comodos;
    }

    public double tamanhoCasa(){
        double tamanhoCasa = 0.0;
        for(Comodo c : comodos){
            tamanhoCasa += c.getLargura() * c.getComprimento();
        }
        return tamanhoCasa;
    }

    public double valorCasa(){
        return tamanhoCasa() * 800;
    }

    public String maiorComodo(){
        String maiorComodo = this.comodos.stream().max(Comparator.comparing(v -> (v.getLargura() * v.getComprimento()))).get().getNome();
        return maiorComodo;
    }

    public ArrayList<ComodoDTO> tamanhoComodos(){
        ArrayList<ComodoDTO> comotoDTO = new ArrayList<>();
        for(Comodo c : comodos){
            comotoDTO.add(new ComodoDTO(c.getNome(), c.getLargura() * c.getComprimento()));
        }
        return comotoDTO;
    }
}
