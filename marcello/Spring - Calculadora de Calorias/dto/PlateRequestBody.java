package br.com.marcello.FoodProject.dto;

import java.util.List;

public class PlateRequestBody {

    String name;
    List<String> ingredientsName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getIngredientsName() {
        return ingredientsName;
    }

    public void setIngredientsName(List<String> ingredientsName) {
        this.ingredientsName = ingredientsName;
    }
}
