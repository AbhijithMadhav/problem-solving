package org.am.concurrency.uber_ride;

import java.util.concurrent.Callable;

record Passenger(UberRide uberRide, PassengerType type) implements Callable<Boolean> {

    @Override
    public Boolean call() throws Exception {
        uberRide.seated(type);
        return true;
    }

    public enum PassengerType {
        DEMOCRAT, REPUBLICAN
    }
}
