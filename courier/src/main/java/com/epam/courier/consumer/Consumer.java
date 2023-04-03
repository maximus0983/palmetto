package com.epam.courier.consumer;

import com.epam.courier.model.Order;
import com.epam.courier.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Consumer {
    private static final String orderTopic = "${topic.name}";

    @Autowired
    private final OrderService service;

    public Consumer(OrderService service) {
        this.service = service;
    }


    @KafkaListener(topics = orderTopic, containerFactory = "userKafkaListenerContainerFactory")
    public void consumeMessage(Order order) throws JsonProcessingException {
        log.info("message consumed {}", order);

        service.cookAndSendOrder(order);
    }
}
