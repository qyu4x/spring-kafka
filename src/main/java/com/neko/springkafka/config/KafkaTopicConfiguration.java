package com.neko.springkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {

    @Bean
    public NewTopic kaffuChinoTopic() {
        return TopicBuilder.name("kaffuchino")
                .partitions(2)
                .build();
    }

}
