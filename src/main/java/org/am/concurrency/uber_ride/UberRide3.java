package org.am.concurrency.uber_ride;

import org.am.concurrency.uber_ride.Passenger.PassengerType;

import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

import static org.am.concurrency.uber_ride.Passenger.PassengerType.DEMOCRAT;
import static org.am.concurrency.uber_ride.Passenger.PassengerType.REPUBLICAN;

public class UberRide3 extends UberRide {

    private final Semaphore demsWaitingSemaphore = new Semaphore(0);
    private final Semaphore repsWaitingSemaphore = new Semaphore(0);
    private final Lock lock = new ReentrantLock(true);
    private final CyclicBarrier barrier = new CyclicBarrier(4);

    private record Quorem(boolean met, int democrats, int republicans){}

    public void republicanArrives() throws InterruptedException, BrokenBarrierException {
        lock.lock();
        printWithThreadContext("Republican arrives");
        Quorem quorem = new Quorem(false, 0, 0);
        if (repsWaiting == 1 && demsWaiting >= 2) {
            repsWaiting -= 1;
            repsWaitingSemaphore.release(1);
            demsWaiting -= 2;
            demsWaitingSemaphore.release(2);
            quorem = new Quorem(true, 2, 2);
            lock.unlock();
        } else if (repsWaiting == 3) {
            repsWaiting -= 3;
            repsWaitingSemaphore.release(3);
            quorem = new Quorem(true, 0, 4);
            lock.unlock();
        } else {
            repsWaiting++;
            lock.unlock();
            printWithThreadContext("Rep waits...");
            repsWaitingSemaphore.acquire();
        }
        printWithThreadContext("Rep seated. Waiting for others...");
        barrier.await();
        if (quorem.met)
            drive(quorem.republicans, quorem.democrats);
    }

    public void democratArrives() throws InterruptedException, BrokenBarrierException {
        lock.lock();
        printWithThreadContext("Democrat arrives");
        Quorem quorem = new Quorem(false, 0, 0);
        if (demsWaiting == 1 && repsWaiting >= 2) {
            demsWaiting -= 1;
            demsWaitingSemaphore.release(1);
            repsWaiting -= 2;
            repsWaitingSemaphore.release(2);
            quorem = new Quorem(true, 0, 4);
            lock.unlock();
        } else if (demsWaiting == 3) {
            demsWaiting -= 3;
            demsWaitingSemaphore.release(3);
            quorem = new Quorem(true, 4, 0);
            lock.unlock();
        } else {
            demsWaiting++;
            printWithThreadContext("Dem waits...");
            lock.unlock();
            demsWaitingSemaphore.acquire();
        }
        printWithThreadContext("Dem seated. Waiting for others...");
        barrier.await();
        if (quorem.met)
            drive(quorem.republicans, quorem.democrats);
    }

    public void seated(PassengerType passengerType) throws InterruptedException, BrokenBarrierException {
        if (passengerType.equals(DEMOCRAT))
            democratArrives();
        else
            republicanArrives();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        UberRide uberRide = new UberRide3();
        List<Passenger> passengers = Stream.of(DEMOCRAT, REPUBLICAN, REPUBLICAN, REPUBLICAN, REPUBLICAN, REPUBLICAN, DEMOCRAT, DEMOCRAT,
                        REPUBLICAN, REPUBLICAN, REPUBLICAN, REPUBLICAN, REPUBLICAN, DEMOCRAT, DEMOCRAT)
                .map(pt -> new Passenger(uberRide, pt))
                .toList();
        try (ExecutorService executorService = Executors.newCachedThreadPool()) {
            executorService.invokeAll(passengers);
        }
    }
}
