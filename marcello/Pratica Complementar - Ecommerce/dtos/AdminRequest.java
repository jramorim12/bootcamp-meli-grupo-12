package br.com.marcello.ECommerce.dtos;

import br.com.marcello.ECommerce.entities.shop.Product;
import br.com.marcello.ECommerce.entities.user.User;

import java.util.List;

public class AdminRequest {

    private User user;
    private List<ProductDto> productsList;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ProductDto> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<ProductDto> productsList) {
        this.productsList = productsList;
    }
}
