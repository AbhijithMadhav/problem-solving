package org.am.concurrency.lru.cache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


// Mutual exclusion : Taken care off
// Starvation : Taken care off
// Deadlocks : Taken care off
// Progress :
public class LRUCache<K, V> {

    private final int size;
    private final Map<K, V> map;

    private final Lock lock = new ReentrantLock(true);

    private final LRUList<K> LRUList;
    public LRUCache(int size) {
        this.size = size;
        map = new HashMap<>(size);
        LRUList = new LRUList<>(size);
    }

    public V get(K key) {
        V value;
        try {
            lock.lock();
            // put key to the end of the dll to imply that this has been used recently
            if (map.containsKey(key)) {
                LRUList.markAsAccessed(key);
            }
        } finally {
            value = map.get(key);
            lock.unlock();
        }
        return value;
    }

    public void put(K key, V value) {
        try {
            lock.lock();
            if (!map.containsKey(key)) {
                if (map.size() < size) {
                    LRUList.markAsAccessed(key);
                } else {
                    map.remove(LRUList.evictLRU());
                }
            }
            map.put(key, value);
        } finally {
            lock.unlock();
        }
    }

    private static class LRUList<K> {
        private final LinkedList<K> dll;

        private LRUList(int size) {
            this.dll = new LinkedList<>();
        }

        private void markAsAccessed(K key) {
            dll.remove(key);
            dll.addLast(key);
        }

        private K evictLRU() {
            return dll.removeFirst();
        }
    }
}