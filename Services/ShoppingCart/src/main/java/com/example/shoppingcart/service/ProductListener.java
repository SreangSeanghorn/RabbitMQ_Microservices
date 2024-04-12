package com.example.shoppingcart.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ProductListener {
    @RabbitListener(queues = "testQueue")
        public void onProductEvent(String message) {

            System.out.println("Product event occurred"+ message);
        }
}
