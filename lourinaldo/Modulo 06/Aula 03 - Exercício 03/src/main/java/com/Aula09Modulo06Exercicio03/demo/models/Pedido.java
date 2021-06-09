package com.Aula09Modulo06Exercicio03.demo.models;

import org.json.simple.JSONObject;

import java.util.ArrayList;

public class Pedido {
    private int id;
    private int mesaID;
    private ArrayList<Prato> pratos;
    private int ativo;

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMesaID() {
        return mesaID;
    }

    public void setMesaID(int mesaID) {
        this.mesaID = mesaID;
    }

    public ArrayList<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(ArrayList<Prato> pratos) {
        this.pratos = pratos;
    }

    public JSONObject toJSON() {

        JSONObject jo = new JSONObject();
        jo.put("id", id);
        jo.put("mesaID", mesaID);
        jo.put("pratos", pratos);
        jo.put("ativo", ativo);

        return jo;
    }
}
