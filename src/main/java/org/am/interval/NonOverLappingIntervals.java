package org.am.interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of intervals intervals where intervals[i] = [starti, endi],
 * return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 */
public class NonOverLappingIntervals {

    // A greedy algorithm
    // Crux is to recognize that for every pair of overlapping interval which interval should be deleted
    // Obviously the one which ends earlier. This minimizes other subsequent intervals overlapped
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        int[] prev = null;
        int count = 0;
        for (int[] cur : intervals) {
            if (prev == null) {
                prev = cur;
                continue;
            }

            if (cur[0] < prev[1]) {
                if (cur[1] < prev[1]) {
                    // prev has to be discarded
                    prev = cur;
                }
                // one of prev or cur has to be discarded
                count++;
            } else
                prev = cur;
        }
        return count;
    }
}
