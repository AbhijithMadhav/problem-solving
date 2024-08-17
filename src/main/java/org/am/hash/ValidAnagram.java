package org.am.hash;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Integer> sMap = getCharMap(s);
        Map<Character, Integer> tMap = getCharMap(t);

        for (Map.Entry<Character, Integer> sEntry : sMap.entrySet()) {
            Character sKey = sEntry.getKey();
            if (!tMap.containsKey(sKey))
                return false;
            if (!sEntry.getValue().equals(tMap.get(sKey)))
                return false;
        }

        return true;
    }

    private Map<Character, Integer> getCharMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
