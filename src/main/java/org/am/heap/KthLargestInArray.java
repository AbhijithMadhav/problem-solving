package org.am.heap;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/description/">...</a>
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Can you solve it without sorting?
 */
public class KthLargestInArray {

    public int findKthLargest(int[] nums, int k) {
        assert k > 0;
        assert nums.length >= k;

        PriorityQueue<Integer> minpq = new PriorityQueue<>();

        for (int num : nums) {
            if (minpq.size() < k)
                minpq.add(num);
            else if (minpq.peek() < num) {
                minpq.remove();
                minpq.add(num);
            }
        }
        return minpq.peek();
    }
}
