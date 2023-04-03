package com.epam.client.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientName;

    private String orderName;

    private int quantity;

    private String deliveryAddress;

    private boolean isCooked;

    private boolean isDelivered;
}
