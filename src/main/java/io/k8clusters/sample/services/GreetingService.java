package io.k8clusters.sample.services;

import io.k8clusters.sample.models.Message;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GreetingService {
    @Timed(value = "greet.time", description = "Time taken to return greet message")
    public Message greet(String name, String message) {
        log.info("Building Message: {}, {}!!!", name, message);
        return Message.builder().name(name).message(message).build();
    }
}
