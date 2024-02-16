package org.am.concurrency.scheduler;

import java.time.Duration;

interface Job {
    int priority();

    long startsAt();

    Duration interval();

    void run();
}
