package org.am.cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    @Test
    public void test() {
        LRUCache lruCache = new LRUCache(5);
        assertEquals(-1, lruCache.get(1));
        lruCache.put(1, 1);
        lruCache.put(2, 1);
        lruCache.put(3, 1);
        lruCache.put(4, 1);
        lruCache.put(5, 1);
        assertNotEquals(-1, lruCache.get(1));
        lruCache.put(6, 1);
        assertEquals(-1, lruCache.get(2));
    }

}