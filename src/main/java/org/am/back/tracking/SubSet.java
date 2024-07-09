package org.am.back.tracking;

import java.util.LinkedList;
import java.util.List;

public class SubSet {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new LinkedList<>();
        subsets.addFirst(new LinkedList<>()); // Need empty set
        for (int size = 1; size <= nums.length; size++) {
            for (int startIndex = 0; startIndex < nums.length; startIndex++) {
                subsets.addAll(subsets(nums, size, startIndex));
            }
        }
        return subsets;
    }

    private List<List<Integer>> subsets(int[] nums, int subsetSize, int startIndex) {
        if (subsetSize == 1) {
            List<Integer> list = new LinkedList<>();
            list.addFirst(nums[startIndex]);
            List<List<Integer>> listList = new LinkedList<>();
            listList.addFirst(list);
            return listList;
        }
        List<List<Integer>> subsets = new LinkedList<>();
        for (int i = startIndex + 1; i + subsetSize - 1 <= nums.length; i++) { // had difficult with this condition
            subsets.addAll(subsets(nums, subsetSize - 1, i)); // general difficulty with visualizing this
        }
        for (List<Integer> subset : subsets) {
            subset.addFirst(nums[startIndex]); // general difficulty with visualizing this
        }
        return subsets;
    }
}
