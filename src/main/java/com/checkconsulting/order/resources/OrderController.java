package com.checkconsulting.order.resources;

import com.checkconsulting.order.utils.CustomResponse;
import com.checkconsulting.order.dto.OrderDto;
import com.checkconsulting.order.utils.ResponseStatus;
import com.checkconsulting.order.exceptions.OrderNotFoundException;
import com.checkconsulting.order.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("orders/{id}")
    public ResponseEntity<CustomResponse<OrderDto>> getOrderById(@PathVariable("id") Integer id){
        try {
            CustomResponse<OrderDto> customResponse = CustomResponse.<OrderDto>builder()
                    .CustomDto(orderService.getOrderById(id))
                    .errorMessage("")
                    .response(ResponseStatus.OK)
                    .build();

            return ResponseEntity.ok(customResponse);
        } catch (OrderNotFoundException e) {
            CustomResponse<OrderDto> customResponse = CustomResponse.<OrderDto>builder()
                    .CustomDto(null)
                    .errorMessage(e.getMessage())
                    .response(ResponseStatus.KO)
                    .build();

            return ResponseEntity.ok(customResponse);
        }
    }
}
