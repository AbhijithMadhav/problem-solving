package org.am.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class MinSubArrayWithKDistinctCharacter {

    public String min(String string, int k) {

        Map<Character, Integer> seenChars = new HashMap<>();
        String min = string;
        boolean found = false;
        for (int start = 0, end = 0; end < string.length(); end++) {

            char charAtEnd = string.charAt(end);
            seenChars.merge(charAtEnd, 1, (v, defaultV) -> v + 1);

            while (seenChars.size()  == k) {
                if (end - start + 1 < min.length()) {
                    min = string.substring(start, end + 1);
                    found = true;
                }
                char charAtStart = string.charAt(start);
                seenChars.computeIfPresent(charAtStart, (key, v) -> v - 1);
                if (seenChars.get(charAtStart) <= 0)
                    seenChars.remove(charAtStart);
                start++;
            }
        }
        return found ? min : "";
    }
}
