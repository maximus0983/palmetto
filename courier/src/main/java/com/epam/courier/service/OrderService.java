package com.epam.courier.service;

import com.epam.courier.model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface OrderService {

    void cookAndSendOrder(Order order) throws JsonProcessingException;

}
