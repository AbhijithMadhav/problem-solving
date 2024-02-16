package org.am.concurrency.print;

public class EvenOdd {

    private final int max;

    public EvenOdd(int max) {
        this.max = max;
    }

    private int counter = 0;

    public synchronized void printEven() {
        while(counter <= max) {
            if (counter % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.err.println("Even thread interrupted. Exiting after notifying...");
                    notify();
                }
            } else {
                System.out.println(counter++);
                notify();
            }
        }
    }

    public synchronized void printOdd() {
        while(counter <= max) {
            if (counter % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.err.println("Odd thread interrupted. Exiting after notifying...");
                    notify();
                }
            } else {
                System.out.println(counter++);
                notify();
            }
        }
    }

    public static void main(String[] s) throws InterruptedException {
        EvenOdd evenOdd = new EvenOdd(50);
        Thread even = new Thread(evenOdd::printEven);
        Thread odd = new Thread(evenOdd::printOdd);
        odd.start();
        even.start();
        even.join();
        odd.join();

    }
}
