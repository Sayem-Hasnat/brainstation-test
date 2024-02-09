package com.hasnat.bs23.service;

import com.hasnat.bs23.constant.ApplicationConstant;
import com.hasnat.bs23.dto.UserDto;
import com.hasnat.bs23.dto.UserEventConsumerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    protected static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private KafkaTemplate<String, UserEventConsumerDto> kafkaTemplate;

    public void sendUserEvents(String message, UserDto userDto) {
        UserEventConsumerDto userConsumerDto = new UserEventConsumerDto(message, userDto);
        kafkaTemplate.send(ApplicationConstant.USER_EVENT, userConsumerDto);
        log.info("kafka Produced message: " + message);
    }
}
