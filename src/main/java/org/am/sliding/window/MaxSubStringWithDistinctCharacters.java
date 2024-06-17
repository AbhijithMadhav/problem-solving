package org.am.sliding.window;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters">...</a>
 */
public class MaxSubStringWithDistinctCharacters {

    public int lengthOfLongestSubstring(String string) {
        int max =  0;
        Set<Character> seen = new HashSet<>();
        for (int l = 0, r = 0; r < string.length(); r++) {
            char c = string.charAt(r);
            while (l <= r && seen.contains(c))
                seen.remove(string.charAt(l++));
            seen.add(c);
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
