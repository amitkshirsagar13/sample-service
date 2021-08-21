package io.k8clusters.sample.models;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
public class Message {
    private String name;
    private String message;

    public String greetings() {
        return String.format("%s, %s!!!", message, name);
    }
}
