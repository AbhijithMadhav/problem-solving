package org.am.sliding.window;

import java.util.Arrays;

/**
 * Find max sub array of size k
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
        int runningSum = Arrays.stream(array, 0, k).sum();
        int max = runningSum;
        int maxStart = 0;
        for (int start = 1; start + k - 1 < array.length; start++) {
            runningSum = runningSum - array[start - 1] + array[start + k -1];
            if (runningSum > max) {
                max = runningSum;
                maxStart = start;
            }
        }

        return Arrays.stream(array, maxStart, maxStart + k).toArray();
    }
}
