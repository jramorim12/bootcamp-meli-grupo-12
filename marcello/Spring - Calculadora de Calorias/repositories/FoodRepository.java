package br.com.marcello.FoodProject.repositories;

import br.com.marcello.FoodProject.dto.IngredientDto;

import java.util.List;

public interface FoodRepository {

    List<IngredientDto> loadIngredientsJson();

    IngredientDto findIngredientByName(String name);

}
