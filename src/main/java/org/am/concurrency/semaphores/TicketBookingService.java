package org.am.concurrency.semaphores;


import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class TicketBookingService {

    private final Semaphore tickets;

    public TicketBookingService(int tickets) {
        this.tickets = new Semaphore(tickets);
    }

    public boolean getTickets(int nTickets) {
        if ( nTickets < 1 || nTickets > 2)
            return false;
        try {
            // So that there is no blocking
            if (!tickets.tryAcquire(nTickets))
                return false;
            processPayment();
        } catch(Exception ex) {
            tickets.release(nTickets);
            return false;
        }
        return true;
    }

    private void processPayment() throws InterruptedException {
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
            boolean success = booking.getTickets(2);
            System.out.println("Request : " + requestId + ", Success : " + success);
            return success;
        };
    }
}