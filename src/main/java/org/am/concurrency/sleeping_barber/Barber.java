package org.am.concurrency.sleeping_barber;

import java.time.Duration;
import java.util.Optional;
import java.util.Random;

class Barber implements Runnable {
    private final BarberShop barberShop;

    public Barber(BarberShop barberShop) {
        this.barberShop = barberShop;
    }

    @Override
    public void run() {
        while (true) {
            Optional<Integer> customer = barberShop.getCustomer();
            if (customer.isPresent()) {
                System.out.println("Barber : Servicing customer " + customer.get() + "...");
                try {
                    Thread.sleep(Duration.ofSeconds(new Random().nextInt(5)));
                    System.out.println("Barber : Finished with customer " + customer.get());
                    barberShop.freeChair();
                } catch (InterruptedException e) {
                    System.out.println("Barber : Got interrupted while servicing customer" + customer.get() + " . Closing shop");
                    break;
                }
            } else {
                try {
                    barberShop.waitForCustomer();
                } catch (InterruptedException e) {
                    System.out.println("Barber : Got interrupted waiting for customers. Closing shop");
                    break;
                }
            }
        }
    }
}
