package org.am.sliding.window;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other
 * uppercase English character. You can perform this operation at most k times.
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 * <a href="https://leetcode.com/problems/longest-repeating-character-replacement/description/">...</a>
 */
public class LongestSubstringWithReplacement {

    public int characterReplacement(String s, int k) {

        int res = 0;
        // count of characters in the current window
        Map<Character, Integer> countMap = new HashMap<>();

        // Examine substrings formed by current window
        for (int r = 0, l = 0; r < s.length(); r++) {
            countMap.compute(s.charAt(r), (key, value) -> value == null ? 1 : value + 1);
            // Crux :
            //  Substring can have same chars with minimum replacement if the non-max chars are replaced
            for (int curWinLength = r - l + 1; curWinLength - curMaxCharCount(countMap) > k; curWinLength--, l++)
                countMap.computeIfPresent(s.charAt(l), (key, value) -> value - 1);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    private static int curMaxCharCount(Map<Character, Integer> countMap) {
        assert !countMap.values().isEmpty();
        return countMap.values().stream().max(Integer::compareTo).get();
    }

}
