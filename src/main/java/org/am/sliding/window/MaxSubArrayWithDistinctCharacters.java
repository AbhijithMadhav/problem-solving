package org.am.sliding.window;

import java.util.HashSet;
import java.util.Set;

// start = 0
// Increment window size as long as sub array contains distinct chars.
// Once distinct chars are k, max-subarray starting with 'start' is obtained, [start, end]
// Now need to do the same for max-subarray starting with start + 1
// start++
// But instead of incrementing the window from start + 1 again you can start from 'end'
// Number of distinct chars is the those in [start, end] minus the adjustment for 'start' which is going to be left out
// Do the same until start reaches end of array or rather start = arrayend - currentMax
public class MaxSubArrayWithDistinctCharacters {
    public int lengthOfLongestSubstring(String string) {
        char[] s = string.toCharArray();
        int max =  0;
        Set<Character> seen = new HashSet<>();
        for (int start = 0, end = 0; start < s.length - max; start++ ) {
            while (end < s.length && !seen.contains(s[end])) {
                seen.add(s[end]);
                end++;
            }
            if (end - start >= max)
                max = end - start;
            seen.remove(s[start]);
        }
        return max;
    }
}
