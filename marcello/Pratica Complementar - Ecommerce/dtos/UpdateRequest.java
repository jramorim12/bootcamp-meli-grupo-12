package br.com.marcello.ECommerce.dtos;

import br.com.marcello.ECommerce.entities.user.User;

public class UpdateRequest {

    private User user;
    private ProductDto product;
    private ProductDto updatedProduct;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ProductDto getProduct() {
        return product;
    }

    public void setProductDto(ProductDto product) {
        this.product = product;
    }

    public ProductDto getUpdatedProduct() {
        return updatedProduct;
    }

    public void setUpdatedProduct(ProductDto updatedProduct) {
        this.updatedProduct = updatedProduct;
    }
}
