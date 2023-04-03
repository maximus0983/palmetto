package com.epam.client.service.impl;

import com.epam.client.model.Order;
import com.epam.client.producer.Producer;
import com.epam.client.repo.OrderRepo;
import com.epam.client.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepo repo;

    @Autowired
    Producer producer;

    @Override
    public Order createAndSendOrder(Order order) throws JsonProcessingException {
        log.info("Create and send order {}", order);
        Order save = save(order);
        producer.sendMessage(save);
        return save;
    }

    @Override
    public Order getOrder(int id) {
        return null;
    }

    @Override
    public Order save(Order order) {
        return repo.save(order);
    }
}
