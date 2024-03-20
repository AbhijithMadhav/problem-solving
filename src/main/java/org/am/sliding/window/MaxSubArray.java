package org.am.sliding.window;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            assert r >= l;
            sum += nums[r];
            maxSum = Math.max(sum, maxSum);
            while(sum < 0)
                sum -= nums[l++];
        }
        return maxSum;
    }
}
