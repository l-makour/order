package com.checkconsulting.order;


import com.checkconsulting.order.model.Orders;
import com.checkconsulting.order.repository.OrderRepository;
import com.checkconsulting.order.services.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//test unitaire
@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    OrderRepository orderRepository;

    @Test
    public void itShouldReturnAllOrders(){
        //given
        Orders order = Orders.builder()
                .id(1)
                .productId(1)
                .status("Status VO")
                .sourceCustomer(0)
                .targetCustomer(0)
                .orderDate(LocalDateTime.now())
                .build();
        List<Orders> ordersList = new ArrayList<>();
        ordersList.add(order);

        Mockito.when(orderRepository.findAll())
                .thenReturn(ordersList);

        //When

        OrderService orderService = new OrderService(orderRepository);
        List<Orders> result = orderService.getAllOrders();

        //then
        Assertions.assertEquals(result.size(), 2);
    }

}
