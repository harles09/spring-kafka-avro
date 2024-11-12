package com.example.avro.Services;

import com.example.avro.schema.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProducerService {

    private final KafkaTemplate<String, User> kafkaTemplate;

    private static final String TOPIC = "user-topic";

    public ResponseEntity<?> sendMessage(User user) {
        kafkaTemplate.send(TOPIC, user.getId().toString(), user);
        return ResponseEntity.ok("Send Message Success");
    }
}
