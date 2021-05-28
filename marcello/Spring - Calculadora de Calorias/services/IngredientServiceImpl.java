package br.com.marcello.FoodProject.services;

import br.com.marcello.FoodProject.dto.IngredientDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collector;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Override
    public IngredientDto getMaxCaloriesIngredient(List<IngredientDto> ingredientsList) {

        Integer maxCalories =  ingredientsList.stream()
                .map(IngredientDto::getCalories)
                .max(Integer::compare)
                .get();

        return ingredientsList.stream()
                .filter(ingredientDto -> ingredientDto.getCalories().equals(maxCalories))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);

    }

    @Override
    public Integer getTotalCalories(List<IngredientDto> ingredientsList) {
        return ingredientsList
                .stream()
                .mapToInt(IngredientDto::getCalories)
                .sum();
    }
}
