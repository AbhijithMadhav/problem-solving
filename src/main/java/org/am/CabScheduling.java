package org.am;

import java.util.Arrays;

/**
 * You want to schedule a certain number of trips with a collection of several cabs.
 * Given an integer n representing a desired number of trips, and an array cabTravelTime representing your cabs
 * and how long it takes each cab (at that index of the array) to make a trip,
 * return the minimum time required to make n trips.
 * Assumption you can make: Cabs can run simultaneously and there is no waiting period between trips.
 * There may be multiple cabs with the same time cost.
 */
public class CabScheduling {

    int minTime(int n, int[] timePerTripForCabs) {
        assert timePerTripForCabs.length > 0;

        int quickestTripTime = Arrays.stream(timePerTripForCabs).min().getAsInt(); // O(k)
        int timeElapsed = 0;
        while(n > 0) { // O(n * k)
            timeElapsed += quickestTripTime;
            for (int cabNo = 0; cabNo < timePerTripForCabs.length && n > 0; cabNo++) { // O(n)
                if (timeElapsed % timePerTripForCabs[cabNo] == 0)
                    n--;
            }
        }
        return timeElapsed;
    }
}
