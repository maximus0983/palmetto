package com.epam.courier.service.impl;

import com.epam.courier.model.Order;
import com.epam.courier.producer.Producer;
import com.epam.courier.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    Producer producer;

    @Override
    public void cookAndSendOrder(Order order) throws JsonProcessingException {
        log.info("Delivery and send order {}", order);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        order.setDelivered(true);
        producer.sendMessage(order);
    }

}
