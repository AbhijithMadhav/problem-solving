package org.am.back.tracking;

import java.util.*;

public class PalindromePartitioning {

    private final List<List<String>> partitions = new LinkedList<>();
    private final Map<String, Boolean> palindromes = new HashMap<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0, new LinkedList<>());
        return partitions;
    }

    // startIndex : the index from where the partitioning should start for incremental lengths
    private void backtrack(String s, int startIndex, List<String> curPartition) {
        if (startIndex >= s.length()) {
            partitions.add(new LinkedList<>(curPartition));
            return;
        }

        // explore solution space for all possible partitions from this node
        for (int len = 1; startIndex + len <= s.length(); len++) {
            String subString = s.substring(startIndex, startIndex + len);
            if (!isPalindrome(subString))
                continue;
            curPartition.add(subString);
            backtrack(s, startIndex + len, curPartition);
            curPartition.removeLast();
        }
    }

    private boolean isPalindrome(String s) {
        if (palindromes.containsKey(s))
            return palindromes.get(s);
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                palindromes.put(s, false);
                return false;
            }
            l++;
            r--;
        }
        palindromes.put(s, true);
        return true;
    }
}
