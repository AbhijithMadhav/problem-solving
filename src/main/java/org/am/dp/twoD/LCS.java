package org.am.dp.twoD;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 * <a href="https://leetcode.com/problems/longest-common-subsequence/description/">...</a>
 */
public class LCS {


    public int lcs(String text1, String text2) {
        return lcs(text1, 0, text2, 0);
    }

    private int lcs(String s, int i, String t, int j) {
        int length = 0;
        if (s.charAt(i) == t.charAt(j)) {
            length = 1;
            if (i + 1 < s.length() && j + 1 < t.length())
                length = 1 + length(s, i + 1, t, j + 1);
        }

        if (i + 1 < s.length())
            length = Math.max(length, length(s, i + 1, t, j));
        if (j + 1 < t.length())
            length = Math.max(length, length(s, i, t, j + 1));

        return length;
    }

    private record Index(int i, int j){}
    private final Map<Index, Integer> cache = new HashMap<>();
    private int length(String s, int i, String t, int j) {
        Index key = new Index(i, j);
        if (!cache.containsKey(key))
            cache.put(key, lcs(s, i, t, j));
        return cache.get(key);
    }
}
