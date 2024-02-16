package org.am.concurrency.sleeping_barber;

class Customer implements Runnable {

    private final BarberShop barberShop;
    private final int id;

    public Customer(BarberShop barberShop, int id) {
        this.barberShop = barberShop;
        this.id = id;
        Thread.currentThread().setName("Customer-" + id);
    }

    @Override
    public void run() {
        if (barberShop.getChair(toString())) {
            barberShop.waitForBarber(id);
        }
    }

    @Override
    public String toString() {
        return "Customer-" + id;
    }
}
