package org.am.dp;

import java.util.HashMap;
import java.util.Map;

public class MinCostClimbing {
    private final Map<Integer, Integer> cache = new HashMap<>();

    public int minCostClimbingStairs(int[] cost) {
        return Math.min(minCostClimbingStairs(cost, 0), minCostClimbingStairs(cost, 1));
    }

    private int minCostClimbingStairs(int[] cost, int i) {
        if (i >= cost.length)
            return 0;
        if (cache.containsKey(i))
            return cache.get(i);
        int plusOne = cache.containsKey(i + 1)
                ? cache.get(i + 1)
                : minCostClimbingStairs(cost, i + 1);
        int plusTwo = cache.containsKey(i + 2)
                ? cache.get(i + 2)
                : minCostClimbingStairs(cost, i + 2);
        cache.put(i, Math.min(cost[i] + plusOne, cost[i] + plusTwo));
        return cache.get(i);
    }
}
