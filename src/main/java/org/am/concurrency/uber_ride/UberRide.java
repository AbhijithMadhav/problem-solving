package org.am.concurrency.uber_ride;

import java.util.concurrent.BrokenBarrierException;

public abstract class UberRide {

    protected int demsWaiting;
    protected int repsWaiting;

    abstract void seated(Passenger.PassengerType type) throws InterruptedException, BrokenBarrierException;

    public void drive(int republicans, int democrats) {
        printWithThreadContext("Driving with " + republicans + " republicans and " + democrats + " democrats. " +
                "Waiting republicans = " + repsWaiting + ", Waiting democrats = " + demsWaiting);
    }

    protected static void printWithThreadContext(String msg) {
        System.out.println(Thread.currentThread().threadId() + " : " + msg);
    }
}