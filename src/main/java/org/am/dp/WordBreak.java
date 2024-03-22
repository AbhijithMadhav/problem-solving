package org.am.dp;

import java.util.*;

/**
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 */
public class WordBreak {

    private final Map<Integer, Boolean> cache = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, 0, new HashSet<>(wordDict));
    }

    // Crux is to recognize and visualize the solution as a decision tree
    private boolean wordBreak(String s, int start, Set<String> wordDict) {

        if (cache.containsKey(start))
            return cache.get(start);

        for (int i = start; i < s.length(); i++) {
            String word = s.substring(start, i + 1);
            if (!wordDict.contains(word))
                continue;
            boolean isBreakable = wordBreak(s, i + 1, wordDict);
            cache.put(start, isBreakable);
            if (isBreakable)
               return true;
        }
        return start >= s.length();
    }
}
