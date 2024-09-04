package org.am.cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class LRUCacheThreadedTest {

    @Test
    public void test() {
        LRUCacheThreaded<String, Integer> lruCacheThreaded = new LRUCacheThreaded<>(5);
        assertNull(lruCacheThreaded.get("a"));
        lruCacheThreaded.put("a", 1);
        lruCacheThreaded.put("b", 1);
        lruCacheThreaded.put("c", 1);
        lruCacheThreaded.put("d", 1);
        lruCacheThreaded.put("e", 1);
        assertNotNull(lruCacheThreaded.get("a"));
        lruCacheThreaded.put("f", 1);
        assertNull(lruCacheThreaded.get("b"));
    }

}