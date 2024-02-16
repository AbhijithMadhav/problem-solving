package org.am.sliding.window;

import java.util.Arrays;

/**
 * Find the smallest subarray with sum greater than or equal to k
 * dynamic window needed
 *
 * array : 1, 6, 5, 3, 8, 2, -1
 * For k = 10, [6,5] . Consider the left most in case of two solutions
 *
 * Brute force solution : Find all possible subarrays. Then find the smallest one amongst them
 * No. of possible subarrays : n + (n-1) + (n - 2) + ... + 1 = O(n^2)
 *
 */
public class SmallestSubArrayWithSumGreaterThanK {

    public int[] smallestSubArrayWithSumK(int[] array, int k) {

        // Dynamic window
        // grow the window until sum of subarray is >= k
        // now reduce the window to size 1 and check if there was a smaller subarray with sum = k
        // Do the same to subarrays starting from every char of the given array

        int minStart = 0;
        int minEnd = array.length;
        boolean found = false;
        for (int start = 0, end = 0, runningSum = 0; start < array.length; ) {
            if (start >= end) {
                end = start;
                runningSum = array[start];
            }

            if (runningSum < k) {
                if (end < array.length - 1) {
                    end++;
                    runningSum += array[end];
                } else {
                    runningSum -= array[start];
                    start++;
                }
            } else {
                if (end - start + 1 < minEnd - minStart + 1) {
                    found = true;
                    minStart = start;
                    minEnd = end;
                }
                runningSum -= array[start];
                start++;
            }
        }

        return found
                ? Arrays.stream(array, minStart, minEnd + 1).toArray()
                : new int[]{};
    }
}
