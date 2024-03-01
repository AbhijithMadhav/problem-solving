package org.am.cache;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MRUCache<K, V> {

    private final int size;
    private final Map<K, V> map;
    private final Deque<K> dll;
    public MRUCache(int size) {
        this.size = size;
        map = new HashMap<>(size);
        dll = new LinkedList<>();
    }

    public synchronized V get(K key) {
        // put key to the end of the dll to imply that this has been used
        if (map.containsKey(key)) {
            dll.remove(key);
            dll.addLast(key);
        }
        return map.get(key);
    }

    public synchronized void put(K key, V value) {
        if (!map.containsKey(key)) {
            if (map.size() < size) {
                dll.addLast(key);
            } else {
                map.remove(dll.removeLast());
            }
        }
        map.put(key, value);
    }


}
