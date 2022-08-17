package com.checkconsulting.order;


import com.checkconsulting.order.dto.OrderDto;
import com.checkconsulting.order.exceptions.OrderNotFoundException;
import com.checkconsulting.order.model.Orders;
import com.checkconsulting.order.model.Status;
import com.checkconsulting.order.repository.OrderRepository;
import com.checkconsulting.order.services.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
                .status(Status.PAYE)
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
        List<OrderDto> result = orderService.getAllOrders();

        //then
        Assertions.assertEquals(result.size(), 1);
    }

    @Test
    public void itShouldReturnOneExistingOrderById() throws OrderNotFoundException {
        //given
        Orders order = Orders.builder()
                .id(1)
                .productId(1)
                .status(Status.PAYE)
                .sourceCustomer(0)
                .targetCustomer(0)
                .orderDate(LocalDateTime.now())
                .build();
        Mockito.when(orderRepository.findById(1)).thenReturn(Optional.of(order));

        //When

        OrderService orderService = new OrderService(orderRepository);
        OrderDto orderDto = orderService.getOrderById(1);
        //then
        Assertions.assertEquals(orderDto.getProductId(), order.getProductId());
        Assertions.assertEquals(orderDto.getOrderDate(), order.getOrderDate());
        Assertions.assertEquals(orderDto.getSourceCustomer(), order.getSourceCustomer());
        Assertions.assertEquals(orderDto.getTargetCustomer(), order.getTargetCustomer());
        Assertions.assertEquals(orderDto.getStatus(), order.getStatus().name());
    }

    @Test
    public void itShouldThrowAnExceptionWhenOrderIdNotExists(){
        //given

        Mockito.when(orderRepository.findById(3)).thenReturn(Optional.empty());

        //When

        OrderService orderService = new OrderService(orderRepository);

        Exception ex
                = Assertions.assertThrows(OrderNotFoundException.class, () -> orderService.getOrderById(3));
        Assertions.assertEquals(ex.getMessage(), "Order with id 3 not found");
    }
}
