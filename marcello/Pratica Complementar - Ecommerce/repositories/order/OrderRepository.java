package br.com.marcello.ECommerce.repositories.order;

import br.com.marcello.ECommerce.dtos.OrderDto;

import java.util.List;

public interface OrderRepository {

    List<OrderDto> addOrder(List<OrderDto> orderList);

    List<OrderDto> getOrders();

}
