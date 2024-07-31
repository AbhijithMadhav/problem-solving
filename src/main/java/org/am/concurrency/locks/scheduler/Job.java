package org.am.concurrency.locks.scheduler;

import java.time.Duration;

interface Job {
    int priority();

    long startsAt();

    Duration interval();

    void run();
}
