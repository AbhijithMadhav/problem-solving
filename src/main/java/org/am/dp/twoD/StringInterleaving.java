package org.am.dp.twoD;

import java.util.HashMap;
import java.util.Map;

/**
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 * An interleaving of two strings s and t is a configuration where s and t are divided into n and m
 * substrings
 * respectively, such that:
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * Note: a + b is the concatenation of strings a and b.
 */

public class StringInterleaving {

    private record Pair(String s1, String s2) {}
    private final Map<Pair, Boolean> cache = new HashMap<>();

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length())
            return false;
        try {
            return canInterleave(s1, s2, s3) || canInterleave(s2, s1, s3);
        } catch (IndexOutOfBoundsException e){
            return false;
        }
    }

    // Can s1 and s2 be interleaved to form s3 starting with a substring of s1
    private boolean canInterleave(String s1, String s2, String s3) {

        Pair key = new Pair(s1, s2);
        if (cache.containsKey(key))
            return cache.get(key);

        if (s1.equals(s3))
            return s2.isEmpty();

        for (int s1IndexExclusive = 1; s1IndexExclusive <= s1.length(); s1IndexExclusive++) {
            String s1Prefix = s1.substring(0, s1IndexExclusive);
            if (!s3.startsWith(s1Prefix))
                return false;
            String remainingS3 = s3.substring(s1IndexExclusive);

            // Cache tells whether interleaving can be done with the remaining parts of s1 and s2
            cache.put(key, canInterleave(s2, s1.substring(s1IndexExclusive), remainingS3));
            if (cache.get(key))
                return true;
        }
        return false;
    }
}
