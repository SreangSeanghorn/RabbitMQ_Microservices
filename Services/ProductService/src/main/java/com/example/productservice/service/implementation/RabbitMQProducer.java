package com.example.productservice.service.implementation;

import com.example.productservice.dto.ProductDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RabbitMQProducer {
    @Autowired
    RabbitTemplate rabbitTemplate;
    public void sendMessageToQueue(String queueName, ProductDTO productDTO){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonObj = objectMapper.writer().withDefaultPrettyPrinter().writeValueAsString(productDTO);
            rabbitTemplate.convertAndSend(queueName, jsonObj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
