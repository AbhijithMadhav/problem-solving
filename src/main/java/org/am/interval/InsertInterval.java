package org.am.interval;

import java.util.LinkedList;
import java.util.List;

/**
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * Return intervals after the insertion.
 * Note that you don't need to modify intervals in-place. You can make a new array and return it.
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<Integer[]> mergedList = new LinkedList<>();

        if (intervals.length == 0)
            return new int[][]{{newInterval[0], newInterval[1]}};

        // Skip all intervals to the left of newInterval
        int i = 0;
        while (i < intervals.length && newInterval[0] > intervals[i][1] ) {
            mergedList.addLast(new Integer[]{intervals[i][0], intervals[i][1]});
            i++;
        }

        // Insert the newInterval or the merged new interval
        if (i < intervals.length)
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        mergedList.addLast(new Integer[]{newInterval[0], newInterval[1]});

        // Insert the intervals to the right
        while (i < intervals.length) {
            mergedList.addLast(new Integer[]{intervals[i][0], intervals[i][1]});
            i++;
        }

        int[][] result = new int[mergedList.size()][2];
        i = 0;
        for (Integer[] interval : mergedList) {
            result[i][0] = interval[0];
            result[i][1] = interval[1];
            i++;
        }
        return result;
    }
}
