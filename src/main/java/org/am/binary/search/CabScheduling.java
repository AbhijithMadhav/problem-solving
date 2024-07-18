package org.am.binary.search;

import java.util.Arrays;

/**
 * You are given an array, `time`, where `time[i]` denotes the time taken by the ith bus to complete one trip.
 * Each bus can make multiple trips successively; that is, the next trip can start immediately after completing
 * the current trip. Also, each bus operates independently; that is, the trips of one bus do not influence the
 * trips of any other bus.
 * You are also given an integer totalTrips, which denotes the number of trips all buses should make in total.
 * Return the minimum time required for all buses to complete at least totalTrips trips.
 */
public class CabScheduling {

    // The crux is to recognize that the solution space is { 0, time taken by the slowest cab to do all the required trips}
        // 0 -> Time taken if totalTrips are 0
        // Time taken by the slowest cab to do all the required trips if there was only one cab and nonzero trips
    // Brute force solution would iteratively calculate the trips for each duration.
    // Complexity can be reduced by using binary search
        // In every iteration, check if trips possible in 'mid' time
        // If it is not possible to do the required trips, the solution space to the left is eliminated
        // If it is possible to do the trips, the solution space to the right is eliminated
            // 'Possible to do the trips' means that atleast the required number of trips can be done, possibly more
    public long minimumTime(int[] cabTimes, int totalTrips) {
        assert cabTimes.length > 0;

        long lo = 1;
        long hi = (long) Arrays.stream(cabTimes).max().getAsInt() * totalTrips;
        long minTime = hi;
        while (lo <= hi) {
            long mid = (hi + lo) / 2;
            if (tripsPossible(cabTimes, mid) >= totalTrips) {
                minTime = mid;
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return minTime;
    }

    private static long tripsPossible(int[] cabTimes, long time) {
       return Arrays.stream(cabTimes).mapToLong(cabTime -> time / cabTime).sum();
    }

}
