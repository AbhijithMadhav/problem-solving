package org.am.cache;

import java.util.LinkedHashMap;

public class MRUCache {

    private final int size;
    private final LinkedHashMap<Integer, Integer> map;

    public MRUCache(int size) {
        this.size = size;
        map = new LinkedHashMap<>(size);
    }

    public Integer get(Integer key) {
        Integer value = -1;
        if (map.containsKey(key)) {
            value = map.get(key);
            // put key to the end of the dll to imply that this has been used recently
            map.putLast(key, value);
        }
        return value;
    }

    public void put(Integer key, Integer value) {
        if (!map.containsKey(key) && map.size() >= size)
            // remove the MRU entry
            map.remove(map.lastEntry().getKey());
        map.putLast(key, value);
    }
}