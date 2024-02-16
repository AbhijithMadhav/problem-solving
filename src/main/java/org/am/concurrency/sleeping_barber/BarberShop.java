package org.am.concurrency.sleeping_barber;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

public class BarberShop {

    private final Semaphore chairs;
    private final BlockingQueue<Integer> waitingCustomers = new LinkedBlockingQueue<>();

    public BarberShop(int nChairs) {
        this.chairs = new Semaphore(nChairs, true);
    }

    boolean getChair(String customer) {
        boolean success = chairs.tryAcquire();
        if (success) {
            System.out.println(BarberShop.class.getSimpleName() +
                    " : Chair successfully acquired by " + customer);
        } else {
            System.out.println(BarberShop.class.getSimpleName() +
                    " : No free chairs for " + customer);
        }
        return success;
    }

    void releaseChair() {
        chairs.release();
    }

    void waitForBarber(int customerId) {
        waitingCustomers.add(customerId);
        synchronized (this) {
            notify();
        }
    }
    Optional<Integer> getNextWaitingCustomer() {
            // Locking is not required as there is only one barber in this problem statement.
            // In case the problem is improvised for multiple barbers this will be needed

            // Can use waitingCustomers.take() which will make the barber thread sleep implicitly
            // Using poll here so that the barber thread can explicitly execute a sleep and put out an output to that effect
            return Optional.ofNullable(waitingCustomers.poll());
    }

    void waitForCustomer() throws InterruptedException {
        System.out.println(BarberShop.class.getSimpleName()
                + " : No customers. Barber will sleep. A new customer has to wake him up..."
        );
        synchronized (this) {
            wait();
        }
    }

    public static void main(String[] s) throws InterruptedException {
        BarberShop barberShop = new BarberShop(3);
        Thread barber = new Thread(new Barber(barberShop));
        barber.start();
        Thread customer1 = new Thread(new Customer(barberShop, 1));
        customer1.start();
        for (int i = 2; i <= 10; i++) {
            new Thread(new Customer(barberShop, i)).start();
        }

        Thread.sleep(Duration.ofSeconds(30));
        for (int i = 11; i <= 20; i++) {
            new Thread(new Customer(barberShop, i)).start();
        }
    }
}
