package org.am.back.tracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 */
public class Permutations {

    // Complexity is O(n!)
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new LinkedList<>();

        if (nums.length == 1) {
            List<Integer> permutation = new LinkedList<>();
            permutation.addFirst(nums[0]);
            result.addFirst(permutation);
            return result;
        }

        // Every iteration is aimed at producing permutations with first element `num`
        for (int num : nums) {
            List<List<Integer>> permutations = permute(exclude(nums, num));
            for (List<Integer> permutation : permutations)
                permutation.addFirst(num);
            // Maybe memoization can be added here with key being the first element
            result.addAll(permutations);
        }

        // Can't this be memoized? key is an array though
        return result;
    }

    private static int[] exclude(int[] nums, int exclude) {
        int[] result = new int[nums.length - 1];
        for (int i = 0, j = 0; i < nums.length; i++){
            if (nums[i] != exclude)
                result[j++] = nums[i];
        }
        return result;
    }
}
