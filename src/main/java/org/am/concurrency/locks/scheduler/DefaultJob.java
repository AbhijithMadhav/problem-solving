package org.am.concurrency.locks.scheduler;

import java.time.Duration;
import java.util.UUID;

public class DefaultJob implements Job {

    private final UUID uuid = UUID.randomUUID();
    private int priority = 0;
    private long startsAt = System.currentTimeMillis();

    private Duration interval;

    public DefaultJob(int priority, long startsAt, Duration interval) {
        this.priority = priority;
        this.startsAt = startsAt;
        this.interval = interval;
    }

    public DefaultJob(long startsAt) {
        this.startsAt = startsAt;
    }

    public DefaultJob(Duration interval) {
        this.interval = interval;
    }

    @Override
    public int priority() {
        return priority;
    }

    @Override
    public long startsAt() {
        return startsAt;
    }

    @Override
    public void run() {
    }

    public Duration interval() {
        return interval;
    }

    @Override
    public String toString() {
        return "DefaultJob{" +
                "uuid=" + uuid +
                ", priority=" + priority +
                ", startsAt=" + startsAt +
                ", interval=" + interval +
                '}';
    }
}
