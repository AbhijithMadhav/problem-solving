package org.am.sliding.window;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a string s and an integer k. You can choose any character of the string and change it to any other
 * uppercase English character. You can perform this operation at most k times.
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 */
public class LongestSubstringWithReplacement {

    public int characterReplacement(String s, int k) {

        int res = 0;
        Map<Character, Integer> countMap = new HashMap<>();
        for (int r = 0, l = 0; r < s.length(); r++) {
            countMap.compute(s.charAt(r), (key, v) -> v == null ? 1 : v + 1);
            while((r - l + 1) - curMaxCharCount(countMap) > k) {
                countMap.computeIfPresent(s.charAt(l), (key, value) -> value - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    private static int curMaxCharCount(Map<Character, Integer> countMap) {
        int maxCharCount  = 0 ;
        for (Integer count : countMap.values()) {
            if (count > maxCharCount)
                maxCharCount = count;
        }
        return maxCharCount;
    }

}
