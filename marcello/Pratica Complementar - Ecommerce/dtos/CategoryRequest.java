package br.com.marcello.ECommerce.dtos;

import br.com.marcello.ECommerce.entities.shop.Category;
import br.com.marcello.ECommerce.entities.user.User;

public class CategoryRequest {

    private User user;
    private Category category;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
