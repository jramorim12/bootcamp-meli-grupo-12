package br.com.marcello.ECommerce.entities.shop;

public enum Category {

    ELECTRONICS("Electronics"),
    CLOTHING("Cloths"),
    HOMETOOLS("Home tools");

    private String category;

    Category(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return this.category;
    }
}
