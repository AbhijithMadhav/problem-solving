package org.am.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((s1, s2) -> s2 - s1);
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
