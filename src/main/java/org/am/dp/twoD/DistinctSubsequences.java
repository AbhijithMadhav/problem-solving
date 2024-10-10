package org.am.dp.twoD;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/distinct-subsequences/description/">...</a>
 * Given two strings s and t, return the number of distinct subsequences of s which equals t.
 * The test cases are generated so that the answer fits on a 32-bit signed integer.
 */
public class DistinctSubsequences {

    public int numDistinct(String s, String t) {
        return numDistinct(s, 0, t, 0);
    }

    private int numDistinct(String s, int i, String t, int j) {
        if (j == t.length())
            return 1;
        if (i == s.length())
            return 0;
        int countByNotMatching = count(s, i + 1, t, j);
        if (s.charAt(i) == t.charAt(j))
            return count(s, i + 1, t, j + 1) + countByNotMatching;
        else
            return countByNotMatching;

    }

    private record Index(int i, int j){}
    private final Map<Index, Integer> cache = new HashMap<>();
    private int count(String s, int i , String t, int j) {
        Index key = new Index(i, j);
        if (!cache.containsKey(key))
            cache.put(key, numDistinct(s, i, t, j));
        return cache.get(key);
    }
}
