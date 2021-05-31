package br.com.marcello.ECommerce.dtos;

import br.com.marcello.ECommerce.entities.shop.Order;
import br.com.marcello.ECommerce.entities.user.User;

import java.util.List;

public class CustomerRequest {

    private User user;
    private List<OrderDto> ordersList;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderDto> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<OrderDto> ordersList) {
        this.ordersList = ordersList;
    }
}
