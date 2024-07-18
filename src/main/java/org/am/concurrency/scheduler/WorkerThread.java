package org.am.concurrency.scheduler;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Mutual exclusion : Taken care off
// Starvation : Taken care off
// Deadlocks : Taken care off
// Progress :
class WorkerThread extends Thread {
    private final AtomicBoolean running = new AtomicBoolean();

    private final BlockingQueue<Job> queue; // to minimize busy-waiting
    private final Lock queueLock = new ReentrantLock(true); // fair=true avoids starvation

    public WorkerThread(BlockingQueue<Job> priorityBlockingQueue) {
        this.queue = priorityBlockingQueue;
    }

    @Override
    public void run() {
        running.set(true);
        do {
            System.out.println(this + " Busy waiting...");
            try {
                getJobFromQueue().ifPresentOrElse(job -> {
                    System.out.println(this + " : " + job + " executing...");
                    job.run();
                }, () -> { // to reduce busy waiting due to a job whose time has not come
                    try {
                        sleep(Duration.ofMillis(1000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException("Thread was interrupted while sleeping to avoid busy waiting", e);
                    }
                });
            } catch (InterruptedException e) {
                System.out.println(this + " is interrupted");
            }
        } while (running.get());
    }

    public Optional<Job> getJobFromQueue() throws InterruptedException {
        Job job;
        try {
            queueLock.lock(); // Mutual exclusion to avoid race condition
            job = queue.take(); // blocking
            if (System.currentTimeMillis() < job.startsAt()) {
                queue.put(job); // Scheduled time is not yet up. So put it back
                job = null;
            }
            if (job != null && job.interval() != null)
                queue.put(new DefaultJob(job.priority(), job.startsAt() + job.interval().toMillis(), job.interval()));
        } finally {
            queueLock.unlock(); // avoid deadlocks
        }
        return job == null ? Optional.empty() : Optional.of(job);
    }

    public void shutdown() {
        running.set(false);
        this.interrupt();
    }
}
