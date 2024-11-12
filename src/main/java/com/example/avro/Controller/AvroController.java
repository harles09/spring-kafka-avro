package com.example.avro.Controller;

import com.example.avro.Services.UserProducerService;
import com.example.avro.schema.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/avro")
public class AvroController {
    private final UserProducerService userProducerService;

    @PostMapping("/send")
    public ResponseEntity<?> sendUserToKafka(@RequestBody User user) {
        return userProducerService.sendMessage(user);
    }
}
