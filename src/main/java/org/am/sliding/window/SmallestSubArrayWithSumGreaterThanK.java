package org.am.sliding.window;

/**
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray
 * whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 */
public class SmallestSubArrayWithSumGreaterThanK {


    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length + 1;

        int total = 0;
        for (int r = 0, l = 0; r < nums.length; r++) {
            total += nums[r];
            while (total >= target) {
                len = Math.min(len, r - l + 1);
                total -= nums[l];
                l++;
            }
        }
        return len < nums.length + 1 ? len : 0;
    }
}
