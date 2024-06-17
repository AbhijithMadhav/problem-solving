package org.am.sliding.window;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/minimum-window-substring/description/
 */
public class MinWindow {

    public String minWindow(String s, String t) {
        Map<Character, Integer> sCount = new HashMap<>();
        Map<Character, Integer> tCount = charCount(t);
        String min = s + t;

        for (int l = 0, r = 0; r < s.length(); r++) {
            sCount.compute(s.charAt(r), (k, v) -> v == null ? 1 : v + 1);
            while (superset(sCount, tCount)) {
                if (min.length() > r - l + 1)
                    min = s.substring(l, r + 1);
                sCount.compute(s.charAt(l), (k, v) -> v == 1 ? null : v - 1);
                l++;
            }
        }
        return min.equals(s + t) ? "" : min;
    }

    private boolean superset(Map<Character, Integer> sCount, Map<Character, Integer> tCount) {
        for (Map.Entry<Character, Integer> entry : tCount.entrySet()) {
            if (!sCount.containsKey(entry.getKey()))
                return false;
            if (sCount.get(entry.getKey()) < entry.getValue())
                return false;
        }
        return true;
    }

    private Map<Character, Integer> charCount(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++)
            count.compute(s.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        return count;
    }
}
