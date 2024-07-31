package org.am.concurrency.locks;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class TicketBookingService {

    private int tickets;
    private final Lock lock = new ReentrantLock(true);

    public TicketBookingService(int tickets) {
        this.tickets = tickets;
    }

    public boolean book(int nRequests) {
        if (nRequests < 1 || nRequests > 2)
            return false;

        lock.lock();
        if (tickets - nRequests >= 0) {
            tickets -= nRequests;
            lock.unlock();
            try {
                processPayments();
                return true;
            } catch (Exception e) {
                lock.lock();
                tickets += nRequests;
                lock.unlock();
                return false;
            }
        }
        lock.unlock();
        return false;
    }

    private void processPayments() throws InterruptedException {
        Thread.sleep(1000);
    }

    public static void main(String[] args) {
        // 10 tickets available
        TicketBookingService bookingService = new TicketBookingService(10);

        // 50 requests
        List<Callable<Boolean>> requests = IntStream.rangeClosed(1, 50)
                .mapToObj(requestId -> getProcessingLambda(requestId, bookingService)).toList();

        try(ExecutorService executorService = Executors.newFixedThreadPool(50)) {
            executorService.invokeAll(requests);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static Callable<Boolean> getProcessingLambda(int requestId, TicketBookingService booking) {
        return () -> {
            boolean success = booking.book(2);
            System.out.println("Request : " + requestId + ", Success : " + success);
            return success;
        };
    }
}
