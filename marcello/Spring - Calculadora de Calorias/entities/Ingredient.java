package br.com.marcello.FoodProject.entities;

public class Ingredient {

    private Long id;
    private String name;
    private Integer calories;

    public Ingredient(Long id, String name, Integer calories) {
        this.id = id;
        this.name = name;
        this.calories = calories;
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

    public Integer getcalories() {
        return calories;
    }

    public void setcalories(Integer weight) {
        this.calories = weight;
    }
}
