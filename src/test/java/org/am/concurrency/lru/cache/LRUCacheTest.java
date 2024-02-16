package org.am.concurrency.lru.cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    @Test
    public void test() {
        LRUCache<String, Integer> lruCache = new LRUCache<>(5);
        assertNull(lruCache.get("a"));
        lruCache.put("a", 1);
        lruCache.put("b", 1);
        lruCache.put("c", 1);
        lruCache.put("d", 1);
        lruCache.put("e", 1);
        assertNotNull(lruCache.get("a"));
        lruCache.put("f", 1);
        assertNull(lruCache.get("b"));
    }

}