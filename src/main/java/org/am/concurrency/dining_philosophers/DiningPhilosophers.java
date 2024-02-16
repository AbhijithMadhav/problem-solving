package org.am.concurrency.dining_philosophers;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class DiningPhilosophers {

    private static final int NUM = 5;
    private final Semaphore[] chopsticks = new Semaphore[NUM];

    public DiningPhilosophers() {
        for (int i = 0; i < NUM; i++) {
            chopsticks[i] = new Semaphore(1, true); // Prevents starvation
        }
    }

    class DP implements Runnable {

        private final int id;

        public DP(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            while(true) {
                int left = id + 1 > NUM - 1 ? (id + 1) % NUM : id + 1;
                int right = id;
                try {
                    if (id == 0) // Prevents circular deadlock
                        eat(chopsticks[right], chopsticks[left]); // to prevent a circular deadlock
                    else
                        eat(chopsticks[left], chopsticks[right]);
                } catch (InterruptedException e) {
                    System.out.println(id + " interrupted...");
                }
            }
        }

        public void eat(Semaphore left, Semaphore right) throws InterruptedException {
            left.acquire();
            right.acquire();
            System.out.println(id + " Eating...");
            try {
                Thread.sleep(new Random().nextInt(2) * 1000);
            } finally {
                right.release();
                left.release();
            }
        }
    }



    public static void main(String[] s) throws InterruptedException {
        DiningPhilosophers diningPhilosophers = new DiningPhilosophers();
        Thread[] t = new Thread[NUM];
        for (int i = 0; i < NUM; i++) {
            t[i] = new Thread(diningPhilosophers.new DP(i));
            t[i].start();
        }

        for (int i = 0; i < NUM; i++) {
            t[i].join();
        }
    }
}
