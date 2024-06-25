package org.am.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1CountMap = new HashMap<>();
        for (Character c : s1.toCharArray())
            s1CountMap.compute(c, (character, count) -> count == null ? 1 : count + 1);

        for (int l = 0, r = s1.length() - 1; r < s2.length(); l++, r = l + s1.length() - 1) {
            Map<Character, Integer> s2CurCountMap = new HashMap<>();
            for (int i = l; i <= r; i++)
                s2CurCountMap.compute(s2.charAt(i), (character, count) -> count == null ? 1 : count + 1);
            if (isPermutation(s1CountMap, s2CurCountMap))
                return true;
        }
        return false;
    }

    private static boolean isPermutation(Map<Character, Integer> s1Map, Map<Character, Integer> s2Map) {
        if (s1Map.size() != s2Map.size())
            return false;
        for (Map.Entry<Character, Integer> s1Entry : s1Map.entrySet()) {
            Character key = s1Entry.getKey();
            Integer value = s1Entry.getValue();
            if (!s2Map.containsKey(key))
                return false;
            if (!s2Map.get(key).equals(value))
                return false;
        }
        return true;
    }
}
