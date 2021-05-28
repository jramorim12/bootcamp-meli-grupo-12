package com.Aula08Modulo06Exercicio01.demo.repository;

import com.Aula08Modulo06Exercicio01.demo.dtos.IngredienteDTO;
import com.Aula08Modulo06Exercicio01.demo.dtos.PratoDTO;

import java.util.List;

public interface RecipesRepository {
   public int caloriasTotais(PratoDTO prato);
   public List<IngredienteDTO> listaIngrediente(PratoDTO prato);
   public String ingredienteMaisCalorico(PratoDTO prato);
}
