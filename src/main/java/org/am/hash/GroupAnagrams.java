package org.am.hash;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> map = new HashMap<>();
        for (String str : strs) {
            Map<Character, Integer> charCount = new HashMap<>();
            for (Character c : str.toCharArray()) {
                charCount.put(c, charCount.getOrDefault(c, 0) + 1);
            }
           if (!map.containsKey(charCount))
               map.put(charCount, new LinkedList<>());
           map.get(charCount).add(str);
        }
        return map.values().stream().toList();
    }
}
