package org.am.dp.twoD;

import java.util.Arrays;

/**
 * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 */
public class CommonSubsequence {

    private int[][] cache;
    public int longestCommonSubsequence(String text1, String text2) {

        if (cache == null) {
            cache = new int[text1.length()][text2.length()];
            for (int[] c : cache)
                Arrays.fill(c,-1);
        }

        if (cache[text1.length() - 1][text2.length() - 1] != -1)
            return cache[text1.length() - 1][text2.length() - 1];

        int len = 0;
        if (text1.charAt(0) == text2.charAt(0)) {
            len = 1;
            if (text1.length() > 1 && text2.length() > 1)
                len += longestCommonSubsequence(text1.substring(1), text2.substring(1));
        }

        if (text2.length() > 1)
            len = Math.max(len, longestCommonSubsequence(text1, text2.substring(1)));
        if (text1.length() > 1)
            len = Math.max(len, longestCommonSubsequence(text1.substring(1), text2));

        cache[text1.length() - 1][text2.length() - 1] = len;
        return len;

    }
}
