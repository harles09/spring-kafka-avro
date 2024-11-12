package com.example.avro.Services;

import com.example.avro.schema.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserConsumerService {

    @KafkaListener(topics = "user-topic", groupId = "avro-consumer-group")
    public void consume(User user) {
        log.info("Consumed user: " + user);
    }
}
