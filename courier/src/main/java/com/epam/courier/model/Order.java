package com.epam.courier.model;

import lombok.Data;

@Data
public class Order {
    private Long id;
    private String clientName;

    private String orderName;

    private int quantity;

    private String deliveryAddress;

    private boolean isCooked;

    private boolean isDelivered;
}
