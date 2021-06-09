package com.Aula08Modulo06Exercicio01.demo.dtos;

import java.util.ArrayList;

public class CaracteristicasDTO {

    private double metrosQuadrados;
    private double valor;
    private String maiorComodo;
    private ArrayList<ComodoDTO> comodos;

    public double getMetrosQuadrados() {
        return metrosQuadrados;
    }

    public void setMetrosQuadrados(double metrosQuadrados) {
        this.metrosQuadrados = metrosQuadrados;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getMaiorComodo() {
        return maiorComodo;
    }

    public void setMaiorComodo(String maiorComodo) {
        this.maiorComodo = maiorComodo;
    }

    public ArrayList<ComodoDTO> getComodos() {
        return comodos;
    }

    public void setComodos(ArrayList<ComodoDTO> comodos) {
        this.comodos = comodos;
    }
}
