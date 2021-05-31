package br.com.marcello.ECommerce.repositories.order;

import br.com.marcello.ECommerce.dtos.OrderDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository  {

    private List<OrderDto> orderList = new ArrayList<>();

    @Override
    public List<OrderDto> getOrders() {
        return this.orderList;
    }

    @Override
    public List<OrderDto> addOrder(List<OrderDto> orderList) {
        this.orderList.addAll(orderList);

        return orderList;
    }
}
