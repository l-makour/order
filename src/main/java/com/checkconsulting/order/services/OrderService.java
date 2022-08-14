package com.checkconsulting.order.services;

import com.checkconsulting.order.dto.OrderDto;
import com.checkconsulting.order.model.Orders;
import com.checkconsulting.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(ord -> mapToOrdersDto(ord) )
                .collect(Collectors.toList());
    }

    public OrderDto mapToOrdersDto(Orders order){
        return OrderDto.builder()
                .productId(order.getProductId())
                .status(order.getStatus().name())
                .sourceCustomer(order.getSourceCustomer())
                .targetCustomer(order.getTargetCustomer())
                .orderDate(order.getOrderDate())
                .build();
    }
}