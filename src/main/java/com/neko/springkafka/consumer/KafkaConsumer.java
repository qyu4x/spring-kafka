package com.neko.springkafka.consumer;

import com.neko.springkafka.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "kaffuchino", groupId = "chino-group")
    void consumeUserTopic(User user) {
        log.info("created user with email -> {} " , user.getEmail());
    }

}
