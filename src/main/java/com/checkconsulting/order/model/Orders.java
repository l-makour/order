package com.checkconsulting.order.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orders {
    @Id
    private Integer id;
    private Integer productId;
    private String status;
    private Integer sourceCustomer;
    private Integer targetCustomer;
    private LocalDateTime orderDate;
}
