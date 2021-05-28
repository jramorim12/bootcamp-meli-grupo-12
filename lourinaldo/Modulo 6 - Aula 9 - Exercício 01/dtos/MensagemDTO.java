package com.Aula08Modulo06Exercicio01.demo.dtos;

import java.util.ArrayList;

public class MensagemDTO {
    private int caloriasPrato;
    private ArrayList<IngredienteDTO> listaIngredientes = null;
    private String ingredienteMaisCalorico = null;

    public int getCaloriasPrato() {
        return caloriasPrato;
    }

    public void setCaloriasPrato(int caloriasPrato) {
        this.caloriasPrato = caloriasPrato;
    }

    public ArrayList<IngredienteDTO> getListaIngredientes() {
        return listaIngredientes;
    }

    public void setListaIngredientes(ArrayList<IngredienteDTO> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }

    public String getIngredienteMaisCalorico() {
        return ingredienteMaisCalorico;
    }

    public void setIngredienteMaisCalorico(String ingredienteMaisCalorico) {
        this.ingredienteMaisCalorico = ingredienteMaisCalorico;
    }
}
