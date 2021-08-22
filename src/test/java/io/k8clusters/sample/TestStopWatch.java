package io.k8clusters.sample;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.TestInfo;
import org.springframework.util.StopWatch;
@Slf4j
public class TestStopWatch {
    private static ThreadLocal<TestStopWatch> testStopWatch = new ThreadLocal<>();

    private StopWatch stopWatch;

    public StopWatch getStopWatch() {
        return this.stopWatch;
    }
    private TestStopWatch(TestInfo testInfo) {
        stopWatch = new StopWatch(testInfo.getDisplayName());
        stopWatch.start(testInfo.getDisplayName());
    }

    public static void startTimer(TestInfo testInfo) {
        if (testStopWatch.get() == null) {
            TestStopWatch inst = new TestStopWatch(testInfo);
            testStopWatch.set(inst);
        }
    }

    public static void stopTimer(TestInfo testInfo) {
        if (testStopWatch.get() == null) {
            startTimer(testInfo);
        }
        final StopWatch stopWatch = testStopWatch.get().getStopWatch();
        stopWatch.stop();
        log.info("Test [{}.{}] Timed: {} ms", testInfo.getTestClass().get().getSimpleName(), testInfo.getTestMethod().get().getName(), stopWatch.getTotalTimeMillis());
    }
}
