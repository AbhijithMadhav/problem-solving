package org.am.sliding.window;

import java.util.HashMap;
import java.util.Map;

// start = 0, end = 0
// end++ : increment window until distinct characters == k
// start++ : decrement window as long as distinct characters == k
// Now we have the minSubarray with k distinct chars for all subarrays ending with 'end'
// Need to do the same for all other chars from end + 1

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
