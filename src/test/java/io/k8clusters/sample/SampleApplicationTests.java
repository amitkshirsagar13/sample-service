package io.k8clusters.sample;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SampleApplicationTests {

    @Test
    void contextLoads() {
        log.info("Run some test!!!");
        log.info("----------------");
        log.info("Ran some test!!!");
    }

}
