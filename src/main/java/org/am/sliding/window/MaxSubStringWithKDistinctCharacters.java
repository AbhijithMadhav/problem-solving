package org.am.sliding.window;

import java.util.HashMap;
import java.util.Map;


public class MaxSubStringWithKDistinctCharacters {

    public String max(String string, int k) {

        Map<Character, Integer> charCount = new HashMap<>();
        String max = "";

        for (int l = 0, r = 0; r < string.length(); r++) {
            charCount.compute(string.charAt(r), (key, value) -> value == null ? 1 : value + 1);
            while (charCount.size() > k) {
                charCount.compute(string.charAt(l), (key, value) -> value == 1 ? null : value - 1);
                l++;
            }
            if (max.length() < r - l + 1)
                max = string.substring(l, r + 1);
        }
        return max;
    }
}
