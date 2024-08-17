package org.am.two.pointer;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/3sum/submissions/1358704908/">...</a>
 */
public class ThreeSum {

    record Triplet(int first, int second, int third){}
    public List<List<Integer>> threeSum(int[] nums) {
        Set<Triplet> triplets = new HashSet<>();
        int[] sorted = Arrays.stream(nums).sorted().toArray(); // nlogn
        for (int i = 0; i < sorted.length; i++) { // n * n
            int first = sorted[i];
            int l = i + 1, r = sorted.length - 1;
            while (l < r) {
                int second = sorted[l];
                int third = sorted[r];
                int target = -(first);
                if (second + third == target) {
                    triplets.add(new Triplet(first, second, third));
                    l++;
                    r--;
                }
                else if (second + third < target)
                    l++;
                else
                    r--;
            }
        }
        return triplets.stream().map(t -> List.of(t.first, t.second, t.third)).toList();
    }
}
