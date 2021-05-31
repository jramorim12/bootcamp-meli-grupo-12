package br.com.marcello.ECommerce.dtos;

import br.com.marcello.ECommerce.entities.user.User;

public class GetRequest {

    User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
