package org.example.kafkaproducer.controllers;

import org.example.kafkaproducer.model.UserActivityEvent;
import org.example.kafkaproducer.services.KafkaActivityProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaActivityProducerController {


    @Autowired
    private KafkaActivityProducerService kafkaProducerService;

    @PostMapping("/user/activity")
    public String sendUserActivityEvent(@RequestBody UserActivityEvent event) {
        kafkaProducerService.sendUserActivityEvent(event);
        return "User activity event recorded successfully!";
    }
}
