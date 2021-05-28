package br.com.marcello.FoodProject.dto;

import java.util.List;

public class PlateDto {

    private String name;
    private List<IngredientDto> ingredientsList;
    private Integer totalCalory;
    private IngredientDto maxCaloryIngredient;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalCalory() {
        return totalCalory;
    }

    public void setTotalCalory(Integer totalCalory) {
        this.totalCalory = totalCalory;
    }

    public IngredientDto getMaxCaloryIngredient() {
        return maxCaloryIngredient;
    }

    public void setMaxCaloryIngredient(IngredientDto maxCaloryIngredient) {
        this.maxCaloryIngredient = maxCaloryIngredient;
    }

    public List<IngredientDto> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(List<IngredientDto> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }
}
