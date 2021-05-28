package br.com.marcello.FoodProject.dto;

public class IngredientDto {

    private String name;
    private Integer calories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalory(Integer calories) {
        this.calories = calories;
    }
}
