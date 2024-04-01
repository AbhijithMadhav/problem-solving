package org.am.greedy;

/**
 * Given an integer array nums, find the
 * subarray with the largest sum, and return its sum.
 */
public class MaxSubArray {

    /*
     * If subarray consists of only +ve numbers the maxSum is simply the sum of all elements
     * -ve numbers decrement sums of all elements.
     * But a -ve number can be a part of a maxSum if other elements on either side of it can compensate
     * Illustration : 1, 2, 3, -3, 4
     * So -ve numbers can't be a part of the maxSum only if they reduce the maxSum to something lesser than zero.
     * In this case the sums of the subarrays on either sides of it will be candidates
     * Illustration : 1, 2, 3, -10, 3, 11
     *
     * So calculate sums across consecutive elements of the array and reset(to a new subarray)
     * only when the sum becomes -ve. This is a greedy choice which works
     * Array : 1, 2, 3, -3, 4, -20, 11, 30
     * Sums  : 1, 3, 6,  3, 7, -13, 11, 41
     * MaxSum : [11, 30] = 41
     *
     * For the extreme case imagine a subarray with only -ve numbers.
     * The maxSum will be just the smallest -ve number. The algo achieves this by reseting for every element
     * Array : -5, -3, -6, -98
     * Sums :  -5, -3, -6, -98
     * MaxSum : -3
     */
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            maxSum = Math.max(sum, maxSum);
            if (sum < 0)
                sum = 0;
        }
        return maxSum;
    }
}
