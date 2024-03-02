package org.am.cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LFUCacheTest {

    @Test
    public void lfuCacheTest() {
        LFUCache lfuCache = new LFUCache(5);
        lfuCache.put(1, 1);
        assertEquals(1, lfuCache.get(1));
        lfuCache.put(2, 2);
        lfuCache.put(3, 3);
        lfuCache.put(4, 4);
        lfuCache.put(5, 5);
        assertEquals(5, lfuCache.get(5));
        lfuCache.put(6, 6);
        assertEquals(6, lfuCache.get(6));
        assertEquals(-1, lfuCache.get(2));
        assertEquals(3, lfuCache.get(3));
        lfuCache.put(7, 7);
        assertEquals(-1, lfuCache.get(4));
    }

    @Test
    public void lfuCacheTest2() {
        LFUCache lfuCache = new LFUCache(1);
        lfuCache.put(2, 1);
        assertEquals(1, lfuCache.get(2));
        lfuCache.put(3, 2);
        assertEquals(-1, lfuCache.get(2));
        assertEquals(2, lfuCache.get(3));
    }

    @Test
    public void lfuCacheTest3() {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.put(2, 1);
        lfuCache.put(1, 1);
        assertEquals(1, lfuCache.get(2));
        lfuCache.put(4, 1);
        assertEquals(-1, lfuCache.get(1));
        assertEquals(1, lfuCache.get(2));
    }
}