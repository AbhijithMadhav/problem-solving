package org.am.concurrency.print;

import java.util.stream.IntStream;

// print numbers until a given max in an order using multiple threads
// the idea is for threads to coordinate amongst themselves using wait and notify/notifyall
public class Printer {

    private final int max;

    public Printer(int max) {
        this.max = max;
    }

    private int counter = 0;

    public synchronized void print(int modulo, int reminder) {
        while(counter <= max) {
            if (counter % modulo != reminder) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.err.println(Thread.currentThread().getName() + ":" + "Thread interrupted. Exiting after notifying...");
                    notifyAll();
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " : " + counter++);
                notifyAll(); // notify all threads waiting on this objects monitor
            }
        }
    }

    public static void main(String[] s) {
        Printer printer = new Printer(1000);
        int nThreads = 3;
        Thread[] threads = new Thread[nThreads];

        IntStream.range(0, threads.length).forEach(i -> {
            threads[i] = new Thread(() -> printer.print(nThreads, i));
            threads[i].start();
        });

        IntStream.range(0, threads.length).forEach(i -> {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
