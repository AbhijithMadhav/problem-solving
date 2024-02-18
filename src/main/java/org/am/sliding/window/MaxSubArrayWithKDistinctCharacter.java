package org.am.sliding.window;

import java.util.HashMap;
import java.util.Map;

// start = 0
// Increment window size as long as distinct chars is less than k.
// Once distinct chars are k, max-subarray starting with 'start' is obtained, say [start, end]
// Now need to do the same for max-subarray starting with start + 1
// start++
// But instead of incrementing the window from start + 1 again you can start from end.
// Number of distinct chars is the those in [start, end] minus the adjustment for start++
// Do the same until start reaches end of array or rather start = arrayend - currentMax
public class MaxSubArrayWithKDistinctCharacter {

    public String max(String string, int k) {

        Map<Character, Integer> seen = new HashMap<>();
        int max = 0;
        int maxStart = 0;
        int maxEnd = 0;
        char[] s = string.toCharArray();
        for (int start = 0, end = 0; start < string.length() - max; start++) {

            while(end < s.length && seen.size() < k) {
                seen.merge(s[end], 1, (v, defaultV) -> v + 1);
                end++;
            }

            while(end < s.length && seen.containsKey(s[end])) {
                seen.computeIfPresent(s[end], (key, v) -> v + 1);
                end++;
            }


            if (max < end - start) {
                max = end - start;
                maxStart = start;
                maxEnd = end;
            }

            seen.computeIfPresent(s[start], (key, v) -> v - 1);
            if (seen.get(s[start]) == 0)
                seen.remove(s[start]);
        }
        return string.substring(maxStart, maxEnd);
    }
}
