package org.am.cache;

import java.util.LinkedHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * <a href="https://leetcode.com/problems/lru-cache/description/">...</a>
 * @param <K>
 * @param <V>
 */
// Mutual exclusion: Taken care off
// Starvation: Taken care off
// Deadlocks: Taken care off
// Progress :
public class LRUCacheThreaded<K, V> {

    private final int size;
    private final LinkedHashMap<K, V> map;

    private final Lock lock = new ReentrantLock(true);

    public LRUCacheThreaded(int size) {
        this.size = size;
        map = new LinkedHashMap<>(size);
    }

    public V get(K key) {
        V value;
        try {
            lock.lock();
            value = map.get(key);
            // put key to the end of the dll to imply that this has been used recently
            if (map.containsKey(key))
                map.putLast(key, value);
        } finally {
            lock.unlock();
        }
        return value;
    }

    public void put(K key, V value) {
        try {
            lock.lock();
            if (!map.containsKey(key) && map.size() >= size)
                map.remove(map.firstEntry().getKey());
            map.putLast(key, value);
        } finally {
            lock.unlock();
        }
    }
}