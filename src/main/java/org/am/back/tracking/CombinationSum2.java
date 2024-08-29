package org.am.back.tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum-ii/description/">...</a>
 */
public class CombinationSum2 {
    // Sorting an array helps with pruning the branches in the backtracking tree.
    // The sorted array helps us build towards the target in the smallest possible way.
    // Once we exceed the target, we need not explore the other numbers as they will also exceed the target due
    // to them being greater
    private final List<List<Integer>> combinations = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, new ArrayList<>(), target);
        return combinations;
    }

    private void backtrack(int[] candidates, int index, List<Integer> currCombi, int target) {
        if (target == 0) {
            combinations.add(new ArrayList<>(currCombi));
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            if (target - candidates[i] >= 0) {
                currCombi.add(candidates[i]);
                backtrack(candidates, i + 1, currCombi, target - candidates[i]);
                currCombi.removeLast();
            } else
                break;
        }
    }
}
