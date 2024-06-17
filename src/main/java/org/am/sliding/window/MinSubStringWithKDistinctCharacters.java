package org.am.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class MinSubStringWithKDistinctCharacters {

    public String min(String string, int k) {
        Map<Character, Integer> countMap = new HashMap<>();
        String minString = string;

        for (int r = 0, l = 0; r < string.length(); r++) {
            countMap.compute(string.charAt(r), (key, value) -> value == null ? 1 : value + 1);
            while (countMap.size() == k) {
                if (minString.length() > r - l + 1)
                    minString = string.substring(l, r + 1);
                countMap.compute(string.charAt(l), (key, value) -> value == 1 ? null : value - 1);
                l++;
            }
        }
        return minString;
    }
}
