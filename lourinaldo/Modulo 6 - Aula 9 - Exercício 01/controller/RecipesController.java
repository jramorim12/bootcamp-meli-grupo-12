package com.Aula08Modulo06Exercicio01.demo.controller;

import com.Aula08Modulo06Exercicio01.demo.repository.RecipesRepository;
import com.Aula08Modulo06Exercicio01.demo.dtos.IngredienteDTO;
import com.Aula08Modulo06Exercicio01.demo.dtos.MensagemDTO;
import com.Aula08Modulo06Exercicio01.demo.dtos.PratoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class RecipesController {

    @Autowired
    private RecipesRepository repository;

    @PostMapping ("/retornarPrato")
    public MensagemDTO retornarInformacoes(@RequestBody PratoDTO prato){

        MensagemDTO mensagemDTO = new MensagemDTO();
        mensagemDTO.setCaloriasPrato(repository.caloriasTotais(prato));
        mensagemDTO.setListaIngredientes((ArrayList<IngredienteDTO>) repository.listaIngrediente(prato));
        mensagemDTO.setIngredienteMaisCalorico(repository.ingredienteMaisCalorico(prato));
        return mensagemDTO;
    }

}
