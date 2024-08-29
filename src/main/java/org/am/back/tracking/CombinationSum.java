package org.am.back.tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target,
 * return a list of all unique combinations of candidates where the chosen numbers sum to target.
 * You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times.
 * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150
 * combinations for the given input.
 * <a href="https://leetcode.com/problems/combination-sum/">...</a>
 */
public class CombinationSum {

    // Sorting an array helps with pruning the branches in the backtracking tree.
    // The sorted array helps us build towards the target in the smallest possible way.
    // Once we exceed the target, we need not explore the other numbers as they will also exceed the target due
    // to them being greater
    private final List<List<Integer>> combis = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, new ArrayList<>(), target);
        return combis;
    }

    private void backtrack(int[] candidates, int index, List<Integer> currCombi, int target) {
        if (target == 0) {
            combis.add(new ArrayList<>(currCombi));
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                currCombi.add(candidates[i]);
                backtrack(candidates, i, currCombi, target - candidates[i]);
                currCombi.removeLast();
            } else
                break;
        }
    }
}
