package br.com.marcello.FoodProject.services;

import br.com.marcello.FoodProject.dto.IngredientDto;

import java.util.List;

public interface IngredientService {

    public IngredientDto getMaxCaloriesIngredient(List<IngredientDto> ingredientsList);

    public Integer getTotalCalories(List<IngredientDto> ingredientsList);

}
