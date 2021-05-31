package br.com.marcello.ECommerce.controllers.product;

import br.com.marcello.ECommerce.dtos.CustomerRequest;
import br.com.marcello.ECommerce.repositories.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepositoryImpl;

    @GetMapping("/getOrders")
    public ResponseEntity<?> getOrders() {
        return new ResponseEntity<>(this.orderRepositoryImpl.getOrders(), HttpStatus.OK);
    }

    @PostMapping("/makeOrder")
    public ResponseEntity<?> makeOrder(@RequestBody CustomerRequest customerRequest) {

        this.orderRepositoryImpl.addOrder(customerRequest.getOrdersList());

        return new ResponseEntity<>(customerRequest.getOrdersList(), HttpStatus.OK);

    }

}
