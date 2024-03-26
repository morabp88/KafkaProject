package org.example.kafkaproducer.services;

import org.example.kafkaproducer.model.UserActivityEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaActivityProducer {

    private static final String TOPIC_NAME = "user_activity_topic";

    @Autowired
    private KafkaTemplate<String, UserActivityEvent> kafkaTemplate;

    public void sendUserActivityEvent(UserActivityEvent event) {
        kafkaTemplate.send(TOPIC_NAME, event.getUserId(), event);
    }
}
