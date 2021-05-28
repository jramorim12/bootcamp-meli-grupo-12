package br.com.marcello.FoodProject.repositories;

import br.com.marcello.FoodProject.dto.IngredientDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class FoodRepositoryImpl implements FoodRepository{

    @Override
    public IngredientDto findIngredientByName(String name) {
        List<IngredientDto> ingredientsJson = null;
        ingredientsJson = this.loadIngredientsJson();
        IngredientDto ingredientDto = null;
        if(ingredientsJson != null) {
            ingredientDto = ingredientsJson.stream()
                    .filter(ingredient -> ingredient.getName().equalsIgnoreCase(name))
                    .findFirst()
                    .orElseThrow(NoSuchElementException::new);
        }

        return ingredientDto;
    }

    @Override
    public List<IngredientDto> loadIngredientsJson() {

        File jsonFile = null;

        try {
            jsonFile = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredientDto>> typeReference = new TypeReference<List<IngredientDto>>() {};
        List<IngredientDto> ingredientsList = null;
        try {
            ingredientsList = objectMapper.readValue(jsonFile, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ingredientsList;

    }

}
