package org.am.queue;

 import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/sliding-window-maximum/description/">...</a>
 */
public class SlidingWindowMax {

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new LinkedList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.getFirst() <= i - k)
                deque.removeFirst();
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[i])
                deque.removeLast();
            deque.addLast(i);
            if (i >= k - 1)
                res.addLast(nums[deque.getFirst()]);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
