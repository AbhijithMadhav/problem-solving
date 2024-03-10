package org.am.sliding.window;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Find the sum of all k length subarrays
 * Sliding window technique : Fixed window
 * start = 0, end = start + 2
 * sum of subarray = sum of previous subarray + new element - old element
 */
public class KSum {

    public static Integer[] ksum(int[] array, int k) {
        if (k < 1)
            return new Integer[]{};

        // Full compute to find the solution of the 1st sub-problem
        List<Integer> ksumList = new LinkedList<>();
        ksumList.add(
                Arrays.stream(array, 0, k).sum()
        );

        // Can use the solution of the previous
        // subproblem to derive the solution of subsequent subproblems
        for (int start = 1; start + k - 1 < array.length; start++)
                ksumList.add(
                        ksumList.getLast() + array[start + k - 1] - array[start - 1]
                );
        return ksumList.toArray(Integer[]::new);
    }
}
