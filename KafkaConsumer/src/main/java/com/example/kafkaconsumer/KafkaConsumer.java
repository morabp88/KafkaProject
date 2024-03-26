package com.example.kafkaconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    KafkaConsumer(){
        System.out.println("Hello Consumer!!");
    }
    @KafkaListener(topics = "user_activity_topic", groupId = "group_id")
    public void listen(String message) {
        System.out.println("Received message: " + message);
        // Process the received message
    }
}
