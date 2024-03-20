package org.am.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class MinWindow {

    public String minWindow(String s, String t) {

        Map<Character, Integer> winCount = new HashMap<>();
        Map<Character, Integer> tCount = new HashMap<>();
        for (Character c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        String minWindow = "";
        int need = tCount.size();
        int have = 0;

        for (int r = 0, l = 0; r < s.length(); r++) {
            char rChar = s.charAt(r);
            if (!tCount.containsKey(rChar))
                continue;

            winCount.put(rChar, winCount.getOrDefault(rChar, 0) + 1);
            if (winCount.get(rChar).equals(tCount.get(rChar)))
                have++;
            for (;have == need; l++) {
                minWindow = updateMinWindow(minWindow, s, l, r);
                char lChar = s.charAt(l);
                if (!tCount.containsKey(lChar))
                    continue;
                winCount.computeIfPresent(lChar, (k, v) -> v - 1);
                if (winCount.get(lChar) < tCount.get(lChar)) {
                    have--;
                }
            }
        }
        return minWindow;
    }

    private String updateMinWindow(String minWindow, String s, int l, int r) {
        String curWindow = s.substring(l, r + 1);
        if (minWindow.isEmpty()) {
            return curWindow;
        }
        return curWindow.length() < minWindow.length() ? curWindow : minWindow;
    }
}
