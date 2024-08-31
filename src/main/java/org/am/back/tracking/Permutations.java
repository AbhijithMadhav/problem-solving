package org.am.back.tracking;

import java.util.*;

/**
 * Given an array nums of distinct integers, return all the possible permutations.
 * You can return the answer in any order.
 */
public class Permutations {

    List<List<Integer>> permutations = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, 0, new HashSet<>(), new ArrayList<>());
        return permutations;
    }

    // index is the index of the starting number of the current permutation
    // state is all the numbers included in the current path/branch
    private void backtrack(int[] nums, int index, Set<Integer> included, List<Integer> currPermutation) {
        if (index == nums.length) {
            permutations.add(new ArrayList<>(currPermutation));
            return;
        }

        for (int num : nums) {
            if (included.contains(num))
                continue;
            currPermutation.addLast(num);
            included.add(num);
            backtrack(nums, index + 1, included, currPermutation);
            included.remove(num);
            currPermutation.removeLast();
        }
    }
}
