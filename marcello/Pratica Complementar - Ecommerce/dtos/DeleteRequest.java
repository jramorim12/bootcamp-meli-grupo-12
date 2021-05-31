package br.com.marcello.ECommerce.dtos;

import br.com.marcello.ECommerce.entities.user.User;

public class DeleteRequest {

    private User user;
    private ProductDto product;

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
}
