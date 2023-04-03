package com.epam.client.service;

import com.epam.client.model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface OrderService {

    Order createAndSendOrder(Order order) throws JsonProcessingException;

    Order getOrder(int id);

    Order save(Order order);
}
