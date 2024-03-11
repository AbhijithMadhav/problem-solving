package org.am.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class MinSubArrayWithKDistinctCharacter {

    public String min(String string, int k) {
        Map<Character, Integer> map = new HashMap<>();
        String minString = string;

        for (int r = 0, l = 0; r < string.length(); r++) {
            map.merge(string.charAt(r), 1, (curValue, initValue) -> curValue + 1);
            while (map.size() == k) {
                String substring = string.substring(l, r + 1);
                if (minString.length() > substring.length())
                    minString = substring;
                map.compute(string.charAt(l), (key, v) -> v > 1 ? v - 1 : null);
                l++;
            }
        }
        return minString;
    }
}
