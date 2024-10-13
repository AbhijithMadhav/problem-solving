package org.am.dp.twoD;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/edit-distance/description/">...</a>
 */
public class EditDistance {

    public int minDistance(String word1, String word2) {
        return minDistance(word1, 0, word2, 0);
    }

    private int minDistance(String s, int i, String t, int j) {

        if (i >= s.length())
            return t.length() - j; // insert operations on s to match it with t
        if (j >= t.length())
            return s.length() - i; // remove operations on s to match it with t

        int distByMovingBoth = distance(s, i + 1, t, j + 1);
        if (s.charAt(i) == t.charAt(j))
            return distByMovingBoth;
        else
            return Math.min(Math.min(
                    1 + distByMovingBoth, // replace
                    1 + distance(s, i + 1, t, j)), // delete char from s
                    1 + distance(s, i, t, j + 1) // insert char into s
            );
    }

    private record Key(int i, int j){}
    private final Map<Key, Integer> cache = new HashMap<>();
    private int distance(String s, int i, String t, int j) {
        Key key = new Key(i, j);
        if (!cache.containsKey(key))
            cache.put(key, minDistance(s, i, t, j));
        return cache.get(key);
    }
}
