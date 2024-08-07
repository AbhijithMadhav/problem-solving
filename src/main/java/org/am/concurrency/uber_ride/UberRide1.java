package org.am.concurrency.uber_ride;

import org.am.concurrency.uber_ride.Passenger.PassengerType;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

import static org.am.concurrency.uber_ride.Passenger.PassengerType.DEMOCRAT;
import static org.am.concurrency.uber_ride.Passenger.PassengerType.REPUBLICAN;


/**
 * <a href="https://github.com/volkodavs/multithreading-playground/blob/master/src/main/java/com/sergeyvolkodav/uberride/README.md">...</a>
 */
public class UberRide1 extends UberRide {

    public synchronized void republicanArrives() {
        repsWaiting++;
        printWithThreadContext("Republican arrives...");
        if (repsWaiting == 2 && demsWaiting >= 2) {
            repsWaiting -= 2;
            demsWaiting -= 2;
            drive(2, 2);
        } else if (repsWaiting == 4) {
            repsWaiting -= 4;
            drive(4, 0);
        }
    }

    public synchronized void democratArrives() {
        demsWaiting++;
        printWithThreadContext("Democrat arrives...");
        if (repsWaiting == 2 && demsWaiting >= 2) {
            repsWaiting -= 2;
            demsWaiting -= 2;
            drive(2, 2);
        } else if (demsWaiting == 4) {
            demsWaiting -= 4;
            drive(0, 4);
        }
    }

    public void seated(PassengerType passengerType) {
        if (passengerType.equals(DEMOCRAT))
            democratArrives();
        else
            republicanArrives();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        UberRide uberRide = new UberRide1();
        List<Passenger> passengers = Stream.of(REPUBLICAN, REPUBLICAN, REPUBLICAN, REPUBLICAN, DEMOCRAT, DEMOCRAT,
                        REPUBLICAN, REPUBLICAN, REPUBLICAN, REPUBLICAN, REPUBLICAN, DEMOCRAT, DEMOCRAT)
                .map(pt -> new Passenger(uberRide, pt))
                .toList();
        try (ExecutorService executorService = Executors.newCachedThreadPool()) {
            executorService.invokeAll(passengers);
        }
    }
}
