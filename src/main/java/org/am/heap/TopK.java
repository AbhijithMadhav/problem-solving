package org.am.heap;

import java.util.*;
import java.util.stream.IntStream;

public class TopK {

    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) { // O(n)
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // O(nlogn)
        // Could also sort here
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        pq.addAll(countMap.entrySet());

        // O(klogn)
        int[] result = new int[k];
        IntStream.range(0, k).forEach(i -> result[i] = pq.remove().getKey());
        return result;
    }
}
