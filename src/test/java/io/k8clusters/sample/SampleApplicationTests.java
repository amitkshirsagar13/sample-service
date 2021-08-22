package io.k8clusters.sample;

import io.k8clusters.sample.models.Message;
import io.k8clusters.sample.services.GreetingService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@Slf4j
public class SampleApplicationTests {

    private GreetingService greetingService;

    @BeforeTestClass
    public static void staticInit(){
        log.info("Initialized SampleApplicationTests");
    }
    @BeforeEach
    public void init(TestInfo testInfo) throws Exception{
        TestStopWatch.startTimer(testInfo);
        log.info("Initialize Mocks: {}", testInfo.getDisplayName());
        greetingService = mock(GreetingService.class);
        when(greetingService.greetSomeone(anyString(), anyString())).thenCallRealMethod();
    }

    @Test
    void checkGreetingMessageWorks() {
        String name = "Groot";
        String greeting = "I am groot";

        Message message = greetingService.greetSomeone(name, greeting);
        assertNotNull(message);
        log.info("Message: {}", message.greetings());
        assertEquals("I am groot, Groot!!!", message.greetings());
    }

    @Test
    void checkGreetingMessageWorksWithNull() {
        String greeting = "I am groot";
        Message message = greetingService.greetSomeone(null, greeting);
        assertNotNull(message);
        log.info("Message: {}", message.greetings());
    }

    @AfterEach
    public void clean(TestInfo testInfo) {
        TestStopWatch.stopTimer(testInfo);
    }
}
