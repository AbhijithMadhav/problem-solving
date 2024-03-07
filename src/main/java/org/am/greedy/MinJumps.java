package org.am.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 * 0 <= j <= nums[i] and
 * i + j < n
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 * Constraints:
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * It's guaranteed that you can reach nums[n - 1].
 */
public class MinJumps {

    private final Map<Integer, Integer> minJumpsByIndex = new HashMap<>();

    public int jump(int[] nums) {
        //return jumpWithMemoization(nums, nums.length);
        return jumpGreedy(nums);
    }

    private int jumpGreedy(int[] nums) {
        int l = 0, r = 0;
        int steps = 0;
        while(r < nums.length - 1) {
            int farthestIndex = getFarthestIndex(nums, l, r);
            l = r + 1;
            r = farthestIndex;
            steps++;
        }
        return steps;
    }

    private static int getFarthestIndex(int[] nums, int l, int r) {
        int farthestIndex = 0;
        for (int i = l; i <= r && i < nums.length; i++) {
            if (i + nums[i] > farthestIndex)
                farthestIndex = i + nums[i];
        }
        return farthestIndex;
    }

    // return count of min jumps to nums[nums.length - 1]
    private int jumpWithMemoization(int[] nums, int length) {

        if (length == 1)
            return 0;
        if (minJumpsByIndex.containsKey(length - 1))
            return minJumpsByIndex.get(length - 1);

        var minJumps = Integer.MAX_VALUE;
        for (var i = 0; i < length - 1; i++) {
            if (nums[i] >= length - 1 - i) {
                var jumpsToNumsi = jumpWithMemoization(nums, i + 1);
                if (jumpsToNumsi + 1 < minJumps) {
                    minJumps = jumpsToNumsi + 1;
                }
            }
        }
        minJumpsByIndex.put(length - 1, minJumps);
        return minJumps;
    }
}
