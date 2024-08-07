package org.am.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
 * "AAJF" with the grouping (1 1 10 6)
 * "KJF" with the grouping (11 10 6)
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 * Given a string s containing only digits, return the number of ways to decode it.
 * The test cases are generated so that the answer fits in a 32-bit integer.
 */
public class Decode {

    private final Map<Integer, Integer> cache = new HashMap<>();
    public int numDecodings(String s) {
        return numDecodings(s, 0);
    }

    // Number of encodings of s starting at position i
    private int numDecodings(String s, int i) {

        if (cache.containsKey(i))
            return cache.get(i);

        int count1 = 0;
        if (i < s.length() && isValidEncoding(s.substring(i, i + 1))) {
            if (i == s.length() - 1)
                count1 = 1;
            else
                count1 = numDecodings(s, i + 1);
        }

        int count2 = 0;
        if (i < s.length() - 1 && isValidEncoding(s.substring(i, i + 2))) {
            if (i == s.length() - 2)
                count2 = 1;
            else
                count2 = numDecodings(s, i + 2);
        }
        cache.put(i, count1 + count2);
        return cache.get(i);
    }

    private boolean isValidEncoding(String encoding) {
        if (encoding.startsWith("0"))
            return false;
        int i = Integer.parseInt(encoding);
        return i >= 1 && i <= 26;
    }
}
