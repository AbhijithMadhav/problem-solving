package org.am.cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MRUCacheTest {

    @Test
    public void test() {
        MRUCache mruCache = new MRUCache(5);
        assertEquals(-1, mruCache.get(1));
        mruCache.put(1, 1);
        mruCache.put(2, 1);
        mruCache.put(3, 1);
        mruCache.put(4, 1);
        mruCache.put(5, 1);
        assertNotEquals(-1, mruCache.get(1));
        mruCache.put(6, 1);
        assertEquals(-1, mruCache.get(5));
    }

}