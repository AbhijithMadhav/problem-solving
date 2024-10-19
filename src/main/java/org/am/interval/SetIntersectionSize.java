package org.am.interval;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/set-intersection-size-at-least-two/description/">...</a>
 */
public class SetIntersectionSize {

    public int intersectionSizeTwo(int[][] intervals) {
        List<int[]> sortedIntervals = Arrays.stream(intervals)
                .sorted(Comparator.comparingInt(interval -> interval[1]))
                .toList();

        Set<Integer> intersectionSet = new HashSet<>();
        for (int[] interval : sortedIntervals) {
            if (intersectionSet.isEmpty()) {
                intersectionSet.add(interval[1]);
                intersectionSet.add(interval[1] - 1);
                continue;
            }
            int intersectionSize = intersectionSize(interval, intersectionSet);
            if (intersectionSize == 0) {
                intersectionSet.add(interval[1]);
                intersectionSet.add(interval[1] - 1);
            } else if (intersectionSize == 1) {
                if (intersectionSet.contains(interval[1]))
                    intersectionSet.add(interval[1] - 1);
                else
                    intersectionSet.add(interval[1]);
            }
        }
        return intersectionSet.size();
    }

    private int intersectionSize(int[] interval, Set<Integer> intersectionSet) {
        return (int)intersectionSet.stream()
                .filter(num -> interval[0] <= num && num <= interval[1])
                .count();
    }
}
