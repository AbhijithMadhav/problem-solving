package org.am.interval;

import java.util.*;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        List<int[]> mergeList = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        for (int[] interval : intervals) {
            if (mergeList.isEmpty())
                mergeList.addLast(interval);
            int[] prevInterval = mergeList.getLast();
            if (interval[0] <= prevInterval[1])
                prevInterval[1] = Math.max(prevInterval[1], interval[1]);
            else
                mergeList.addLast(interval);
        }

        return mergeList.toArray(new int[][]{});
    }
}
