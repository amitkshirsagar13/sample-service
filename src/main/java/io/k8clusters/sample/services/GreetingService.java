package io.k8clusters.sample.services;

import io.k8clusters.sample.models.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GreetingService {
    public Message greetSomeone(String name, String message) {
        log.info("Building Message!!!");
        return Message.builder().name(name).message(message).build();
    }
}
