package com.checkconsulting.order.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @Enumerated(EnumType.STRING)
    private Status status;
    private Integer sourceCustomer;
    private Integer targetCustomer;
    private LocalDateTime orderDate;
}
