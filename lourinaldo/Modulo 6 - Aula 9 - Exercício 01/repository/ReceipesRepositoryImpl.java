package com.Aula08Modulo06Exercicio01.demo.repository;

import com.Aula08Modulo06Exercicio01.demo.dtos.IngredienteDTO;
import com.Aula08Modulo06Exercicio01.demo.dtos.PratoDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Repository
public class ReceipesRepositoryImpl implements RecipesRepository{

    @Override
    public int caloriasTotais(PratoDTO prato) {
        List<IngredienteDTO> ingredientesList = this.loadDataBase();
        int caloriasTotais = 0;
        for(String ingrediente : prato.getIngredientes()){
            caloriasTotais += 1;
            caloriasTotais += ingredientesList.stream().filter(i -> ingrediente.equalsIgnoreCase(i.getName())).findFirst().get().getCalories();
        }

        return caloriasTotais;
    }

    @Override
    public List<IngredienteDTO> listaIngrediente(PratoDTO prato) {
        List<IngredienteDTO> ingredientesList = this.loadDataBase();
        List<IngredienteDTO> aux = new ArrayList<>();
        for(String ingrediente : prato.getIngredientes()){
            aux.add(ingredientesList.stream().filter(i -> ingrediente.equalsIgnoreCase(i.getName())).findFirst().get());
        }
        return aux;
    }

    @Override
    public String ingredienteMaisCalorico(PratoDTO prato) {
        List<IngredienteDTO> aux = listaIngrediente(prato);
        return aux.stream().max(Comparator.comparing(v->v.getCalories())).get().getName();
    }

    private List<IngredienteDTO> loadDataBase() {
        File file = null;

        try{
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredienteDTO>> typeReference = new TypeReference<>(){};
        List<IngredienteDTO> lista = null;

        try{
            lista = objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lista;
    }

}
