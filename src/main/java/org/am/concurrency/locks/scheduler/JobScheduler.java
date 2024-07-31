package org.am.concurrency.locks.scheduler;


import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

// jobs have priorities
// jobs have timestamps
// jobs have frequencies
// scheduler has a pool of workers to schedule these jobs
public class JobScheduler {

    private final BlockingQueue<Job> queue = new PriorityBlockingQueue<>(10, (o1, o2) -> {
        int pDifference = o1.priority() - o2.priority();
        if (pDifference != 0)
            return pDifference;
        return  o1.startsAt() - o2.startsAt() < 0 ? -1 : o1.startsAt() - o2.startsAt() > 0 ? 1 : 0;
    });
    List<WorkerThread> workerThreads = new LinkedList<>();

    public JobScheduler(int nThreads) {
        for (int i = 0; i < nThreads; i++) {
            WorkerThread t = new WorkerThread(queue);
            workerThreads.add(t);
            t.start();
        }
    }
    public void submit(Job job) {
        System.out.println("submitting : " + job);
        synchronized (queue) {
            queue.add(job);
        }
    }

    public void shutdown() {
        workerThreads.forEach(WorkerThread::shutdown);
    }
}

