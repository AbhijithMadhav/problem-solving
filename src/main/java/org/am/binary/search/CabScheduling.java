package org.am.binary.search;

import java.util.Arrays;

/**
 * You are given an array time where time[i] denotes the time taken by the ith bus to complete one trip.
 * Each bus can make multiple trips successively; that is, the next trip can start immediately after completing
 * the current trip. Also, each bus operates independently; that is, the trips of one bus do not influence the
 * trips of any other bus.
 * You are also given an integer totalTrips, which denotes the number of trips all buses should make in total.
 * Return the minimum time required for all buses to complete at least totalTrips trips.
 */
public class CabScheduling {

    public long minimumTime(int[] cabTimes, int totalTrips) {
        assert cabTimes.length > 0;

        long lo = 1;
        long hi = (long) Arrays.stream(cabTimes).max().getAsInt() * totalTrips;
        long minTime = hi;
        while (lo <= hi) {
            long mid = (hi + lo) / 2;
            if (canDoTrips(cabTimes, mid, totalTrips)) {
                minTime = mid;
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return minTime;
    }

    private static boolean canDoTrips(int[] cabTimes, long time, int totalTrips) {
        long trips = 0;
        for (int cabTime : cabTimes)
            trips += time / cabTime;
        return trips >= totalTrips;
    }

}
