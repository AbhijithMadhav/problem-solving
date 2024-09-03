package org.am.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/kth-largest-element-in-a-stream/description/">...</a>
 */
public class KthLargestInStream {

    private final int k;
    private final PriorityQueue<Integer> minpq = new PriorityQueue<>();

    public KthLargestInStream(int k, int[] nums) {
        this.k = k;
        assert k <= nums.length;
        Arrays.stream(nums).forEach(this::add);
    }

    public int add(int val) {
        assert k > 0;
        if (minpq.size() < k)
            minpq.add(val);
        else if (val > minpq.peek()) {
           if (minpq.size() == k)
               minpq.remove();
           minpq.add(val);
        }
       return minpq.isEmpty() ? -1 : minpq.peek();
    }
}
