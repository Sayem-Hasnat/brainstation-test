package com.hasnat.bs23.config;

import com.hasnat.bs23.constant.ApplicationConstant;
import com.hasnat.bs23.dto.UserEventConsumerDto;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.TopicBuilder;


@Configuration
public class KafkaConfig {
    protected static final Logger log = LoggerFactory.getLogger(KafkaConfig.class);

    @Bean
    public NewTopic topic() {
        return TopicBuilder
                .name(ApplicationConstant.USER_EVENT)
                .build();
    }

    @KafkaListener(topics = ApplicationConstant.USER_EVENT, groupId = ApplicationConstant.KAFKA_GROUP_ID)
    private void userConsumer(UserEventConsumerDto consumerDto) {
        log.info(consumerDto.getMessage());
        log.info("--------------------------");

        log.info(consumerDto.getUserDto().getUsername());
        log.info(consumerDto.getUserDto().getEmail());
        log.info(consumerDto.getUserDto().getName());
        log.info("--------------------------");
    }

}
