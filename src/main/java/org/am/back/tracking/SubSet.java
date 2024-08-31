package org.am.back.tracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array nums of unique elements, return all possible subsets(the power set).
 * The solution set must not contain duplicate subsets.
 * Return the solution in any order.
 * <a href="https://leetcode.com/problems/subsets/">...</a>
 */
public class SubSet {

    List<List<Integer>> subsets = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return subsets;
    }

    // index : Index of the starting element
    public void backtrack(int[] nums, int index, List<Integer> currentSubset) {
        // solutions formed at each node
        subsets.add(new ArrayList<>(currentSubset));

        // Branch for all subsets starting with subsequent elements
        for (int i = index; i < nums.length; i++) {
            currentSubset.addLast(nums[i]);
            backtrack(nums, i + 1, currentSubset);
            currentSubset.removeLast();
        }
    }
}
