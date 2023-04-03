package com.epam.courier.producer;

import com.epam.courier.model.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Producer {
    @Value("${topic.name}")
    private String orderTopic;

    private final KafkaTemplate<String, Order> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String sendMessage(Order foodOrder) {
        kafkaTemplate.send(orderTopic,"courier", foodOrder);

        log.info("food order produced {}", foodOrder);

        return "message sent";
    }
}
