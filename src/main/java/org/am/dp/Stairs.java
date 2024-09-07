package org.am.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/climbing-stairs/description/">...</a>
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class Stairs {
    private final Map<Integer, Integer> cache = new HashMap<>();
    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        int stepsNMinusOne = cache.containsKey(n - 1) ? cache.get(n - 1) : climbStairs(n - 1);
        int stepsNMinusTwo = cache.containsKey(n - 2) ? cache.get(n - 2) : climbStairs(n - 2);
        cache.put(n, stepsNMinusOne + stepsNMinusTwo);
        return cache.get(n);
    }
}
