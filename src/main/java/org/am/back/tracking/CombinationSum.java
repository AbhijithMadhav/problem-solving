package org.am.back.tracking;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency
 *  of at least one of the chosen numbers is different.
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 *
 */
public class CombinationSum {

    // sorting an array helps with pruning the branches in the backtracking tree
    // The sorted array helps us build towards the target in the smallest possible way
    // Once we exceed the target we need not explore the other numbers as they will also exceed the target due to them being greater
    // Sorting also helps with
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return recursizeCombinationSum(Arrays.stream(candidates).sorted().toArray(), target);
    }

    public List<List<Integer>> recursizeCombinationSum(int[] candidates, int target) {
        List<List<Integer>> listList = new LinkedList<>();

        for (int i = 0; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                // This is where the sorting helps.
                // Need not loop through the other numbers as they will certainly exceed the target
                break;
            }
            else if (target - candidates[i] == 0) {
                List<Integer> list = new LinkedList<>();
                list.add(candidates[i]);
                listList.add(list);
                break; // This is where the sorting helps.
            } else {
                List<List<Integer>> subList = recursizeCombinationSum(
                        // We need not consider candidates before i as they have already been considered
                        // and would form duplicate candidate sums otherwise
                        Arrays.stream(candidates, i, candidates.length).toArray(),
                        target - candidates[i]
                );

                for (List<Integer> l : subList) {
                    l.addFirst(candidates[i]);
                }
                listList.addAll(subList);
            }
        }
        return listList;
    }
}
