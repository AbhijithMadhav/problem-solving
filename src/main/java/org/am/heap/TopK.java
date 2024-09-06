package org.am.heap;

import java.util.*;


/**
 * <a href="https://leetcode.com/problems/top-k-frequent-elements/">...</a>
 */
public class TopK {

    public int[] topKFrequent(int[] nums, int k) {

        assert k > 0;
        Map<Integer, Integer> countMap = new HashMap<>();

        // O(n)
        Arrays.stream(nums).forEach(num -> countMap.put(num, countMap.getOrDefault(num, 0) + 1));

        // O(n log k)
        // Could also sort here. But that would be O(n log n)
        // Min heap
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        countMap.entrySet().forEach(entry -> {
            pq.add(entry); // log k
            if (pq.size() > k)
                pq.remove(); // log k
        });

        return pq.stream().mapToInt(Map.Entry::getKey).toArray();
    }
}
