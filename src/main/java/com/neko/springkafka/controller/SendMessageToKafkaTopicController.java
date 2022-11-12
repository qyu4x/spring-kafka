package com.neko.springkafka.controller;

import com.neko.springkafka.entity.User;
import com.neko.springkafka.kafka.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/events")
public class SendMessageToKafkaTopicController {

    private KafkaProducerService kafkaProducerService;

    @Autowired
    public SendMessageToKafkaTopicController(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @PostMapping("/create-user")
    public void sendMessageToKafka(@RequestBody User user) {
        User sendUserToKafka = new User(
                UUID.randomUUID().toString(),
                user.getUsername(),
                user.getEmail()
        );

        kafkaProducerService.saveCreateUserLog(sendUserToKafka);
    }

}
