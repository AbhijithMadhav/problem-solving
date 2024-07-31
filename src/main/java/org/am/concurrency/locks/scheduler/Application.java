package org.am.concurrency.locks.scheduler;

import java.time.Duration;
import java.util.stream.IntStream;

public class Application {

    public static void main(String[] s) throws InterruptedException {
        JobScheduler jobScheduler = new JobScheduler(4);
        jobScheduler.submit(new DefaultJob(System.currentTimeMillis() + 1000));
        IntStream.range(0, 25).forEach(i -> jobScheduler.submit(new DefaultJob(System.currentTimeMillis() + i)));
        jobScheduler.submit(new DefaultJob(Duration.ofMillis(5000)));
        Thread.sleep(5000);
        jobScheduler.shutdown();
    }
}
