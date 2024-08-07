package org.am.concurrency.uber_ride;

import org.am.concurrency.uber_ride.Passenger.PassengerType;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

import static org.am.concurrency.uber_ride.Passenger.PassengerType.DEMOCRAT;
import static org.am.concurrency.uber_ride.Passenger.PassengerType.REPUBLICAN;

public class UberRide2 extends UberRide {

    private final Semaphore demsWaitingSemaphore = new Semaphore(0);
    private final Semaphore repsWaitingSemaphore = new Semaphore(0);
    private final Lock lock = new ReentrantLock(true);

    public void republicanArrives() throws InterruptedException {
        lock.lock();
        printWithThreadContext("Republican arrives...");
        if (repsWaiting == 1 && demsWaiting >= 2) {
            repsWaiting -= 1;
            repsWaitingSemaphore.release(1);
            demsWaiting -= 2;
            demsWaitingSemaphore.release(2);
            drive(2, 2);
            lock.unlock();
        } else if (repsWaiting == 3) {
            repsWaiting -= 3;
            repsWaitingSemaphore.release(3);
            drive(4, 0);
            lock.unlock();
        } else {
            repsWaiting++;
            lock.unlock();
            printWithThreadContext("Rep waits...");
            repsWaitingSemaphore.acquire();
            printWithThreadContext("Rep seated...");
        }
    }

    public void democratArrives() throws InterruptedException {
        lock.lock();
        printWithThreadContext("Democrat arrives...");
        if (demsWaiting == 1 && repsWaiting >= 2) {
            demsWaiting -= 1;
            demsWaitingSemaphore.release(1);
            repsWaiting -= 2;
            repsWaitingSemaphore.release(2);
            drive(2, 2);
            lock.unlock();
        } else if (demsWaiting == 3) {
            demsWaiting -= 3;
            demsWaitingSemaphore.release(3);
            drive(0, 4);
            lock.unlock();
        } else {
            demsWaiting++;
            printWithThreadContext("Dem waits...");
            lock.unlock();
            demsWaitingSemaphore.acquire();
            printWithThreadContext("Dem seated...");
        }
    }

    public void seated(PassengerType passengerType) throws InterruptedException {
        if (passengerType.equals(DEMOCRAT))
            democratArrives();
        else
            republicanArrives();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        UberRide uberRide = new UberRide2();
        List<Passenger> passengers = Stream.of(DEMOCRAT, REPUBLICAN, REPUBLICAN, REPUBLICAN, REPUBLICAN, REPUBLICAN, DEMOCRAT, DEMOCRAT,
                        REPUBLICAN, REPUBLICAN, REPUBLICAN, REPUBLICAN, REPUBLICAN, DEMOCRAT, DEMOCRAT)
                .map(pt -> new Passenger(uberRide, pt))
                .toList();
        try (ExecutorService executorService = Executors.newCachedThreadPool()) {
            executorService.invokeAll(passengers);
        }
    }
}
