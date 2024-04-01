package org.am.heap;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Can you solve it without sorting?
 */
public class KthLargest {

    private record Int(Integer num) implements Comparable<Int> {

        @Override
        public int compareTo(Int o) {
            return o.num - this.num;
        }
    }
    public int findKthLargest(int[] nums, int k) {
        assert nums.length >= k;

        // constructing a max heap in java(via heapify) with a custom comparator(for max heap in this case)
        PriorityQueue<Int> pq = new PriorityQueue<>(
                Arrays.stream(nums).mapToObj(Int::new).collect(Collectors.toList())
        );

        int result = nums[0];
        for (int i = 0; i < k; i++)
            result = pq.remove().num;
        return result;
    }
}
