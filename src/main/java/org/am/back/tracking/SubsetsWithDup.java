package org.am.back.tracking;

import java.util.*;

/**
 * Given an integer array nums that may contain duplicates, return all possible subsets(the power set).
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 * <a href="https://leetcode.com/problems/subsets-ii/">...</a>
 */
public class SubsetsWithDup {
    List<List<Integer>> subsets = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return subsets;
    }

    public void backtrack(int[] nums, int index, List<Integer> currentSubset) {
        subsets.add(new ArrayList<>(currentSubset));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;
            currentSubset.addLast(nums[i]);
            backtrack(nums, i + 1, currentSubset);
            currentSubset.removeLast();
        }
    }
}
