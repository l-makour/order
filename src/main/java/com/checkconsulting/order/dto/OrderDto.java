package com.checkconsulting.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
    private Integer productId;
    private String status;
    private Integer sourceCustomer;
    private Integer targetCustomer;
    private LocalDateTime orderDate;
}
