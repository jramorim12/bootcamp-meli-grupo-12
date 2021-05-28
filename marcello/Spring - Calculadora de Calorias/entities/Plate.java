package br.com.marcello.FoodProject.entities;

import java.util.List;

public class Plate {

    private Long id;
    private String name;
    private List<Ingredient> ingredientsList;

    public Plate(Long id, String name, List<Ingredient> ingredientsList) {
        this.id = id;
        this.name = name;
        this.ingredientsList = ingredientsList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(List<Ingredient> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }
}
