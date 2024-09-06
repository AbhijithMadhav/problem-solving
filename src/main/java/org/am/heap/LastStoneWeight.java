package org.am.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/last-stone-weight/">...</a>
 */
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.stream(stones).forEach(pq::add);

        while (!pq.isEmpty()) {
            int y = pq.remove();
            if (pq.isEmpty())
                return y;
            int x = pq.remove();
            assert y >= x;
            if (x != y)
                pq.add(y - x);
        }
        return 0;
    }
}
