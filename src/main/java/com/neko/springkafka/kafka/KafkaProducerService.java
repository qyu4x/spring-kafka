package com.neko.springkafka.kafka;

import com.neko.springkafka.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaProducerService {

    private KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void saveCreateUserLog(User user) {
        log.info("send user {} to topic ", user.getUsername());
        this.kafkaTemplate.send("kaffuchino", user);
    }
}
