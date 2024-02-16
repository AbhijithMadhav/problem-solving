package org.am.sliding.window;

import java.util.Arrays;

/**
 * Find max sub array of size k
 *
 * Fixed window
 */
public class MaxSubArrayOfSizeK {

    public int[] maxSubArrayOfSizeK(int[] array, int k) {
        // array has to be of size atleast k
        if (array.length < k)
            return new int[0];

        // for all possible subarray of size k calculate sum : running sum
        // compare against max found so far
        // replace max with running sum if later is greater
        int max = Integer.MIN_VALUE;
        int maxStart = 0;
        int runningSum = 0;
        for (int start = 0; start + k - 1 < array.length; start++) {
            runningSum = getRunningSum(array, start, start + k - 1, runningSum);
            if (runningSum > max) {
                max = runningSum;
                maxStart = start;
            }
        }

        return Arrays.stream(array, maxStart, maxStart + k).toArray();
    }

    private int getRunningSum(int[] array, int start, int end, int previousSubArraySum) {
        return start == 0
                ? Arrays.stream(array, start, end + 1).sum()
                : previousSubArraySum - array[start - 1] + array[end];
    }
}
