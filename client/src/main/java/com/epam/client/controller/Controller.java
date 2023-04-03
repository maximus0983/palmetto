package com.epam.client.controller;

import com.epam.client.model.Order;
import com.epam.client.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Controller {
    @Autowired
    OrderService service;

    @PostMapping
    public Order createOreder(@RequestBody Order order) throws JsonProcessingException {
        return service.createAndSendOrder(order);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int id) {
        return service.getOrder(id);
    }
}
