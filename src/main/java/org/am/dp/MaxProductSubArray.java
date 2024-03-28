package org.am.dp;

/**
 * Given an integer array nums, find a
 * subarray
 *  that has the largest product, and return the product.
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 */
public class MaxProductSubArray {
    public int maxProductBruteForce(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int product = nums[i];
           for (int j = i + 1; j < nums.length; j++) {
               product *= nums[j];
               maxProduct = Math.max(maxProduct, product);
           }
        }
        return maxProduct;
    }

    // Very complicated
    // Requires recognizing that the product can decrease and increase with the multiplicands being -ve or +ve
    // In a linear scan of only +ve numbers the product would be increasing
    // But when a -ve number is encountered the product can decrease. The max seen so far will become the min
    // So we stop multiplying and we've got a subarray. We start with a new one
    // But if we get another -ve number the previous min multiplied with this will give a max.
    // So we maintain the max current subarray and the min current subarray
    public int maxProduct(int[] nums) {
        int curMax = nums[0], curMin = nums[0], maxProduct = nums[0];
        // curMax = max current subarray
        // curMin = min current subarray
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int tmp = curMax;
            curMax = Math.max(num, Math.max(num * curMax, num * curMin));
            curMin = Math.min(num, Math.min(num * tmp, num * curMin));
            maxProduct = Math.max(maxProduct, Math.max(curMax, curMin));
        }
        return maxProduct;
    }
}
