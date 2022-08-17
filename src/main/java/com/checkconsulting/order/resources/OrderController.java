package com.checkconsulting.order.resources;

import com.checkconsulting.order.dto.OrderDto;
import com.checkconsulting.order.model.Orders;
import com.checkconsulting.order.services.OrderService;
import org.springframework.http.ResponseEntity;
import com.checkconsulting.order.model.Orders;
import com.checkconsulting.order.services.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("orders")
    public ResponseEntity<List<OrderDto>>  getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

}
