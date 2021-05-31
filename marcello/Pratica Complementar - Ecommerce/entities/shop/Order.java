package br.com.marcello.ECommerce.entities.shop;

import java.util.List;

public class Order {

    private Long id;
    private List<Product> productsList;
    private Double totalPrice;

    public Order(Long id, List<Product> productsList, Double totalPrice) {
        this.id = id;
        this.productsList = productsList;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
