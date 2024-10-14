package org.am.dp;

import java.util.*;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * <a href="https://leetcode.com/problems/word-break/description/">...</a>
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, 0, new HashSet<>(wordDict));
    }

    // Crux is to recognize and visualize the solution as a decision tree
    private boolean wordBreak(String s, int start, Set<String> wordDict) {

        for (int i = start; i < s.length(); i++) {
            String word = s.substring(start, i + 1);
            if (!wordDict.contains(word))
                continue;
            boolean isBreakable = cache(s, i + 1, wordDict);
            if (isBreakable)
               return true;
        }
        return start >= s.length();
    }

    private final Map<Integer, Boolean> cache = new HashMap<>();
    private boolean cache(String s, int start, Set<String> wordDict) {
        if (!cache.containsKey(start))
            cache.put(start, wordBreak(s, start, wordDict));
        return cache.get(start);
    }
}
