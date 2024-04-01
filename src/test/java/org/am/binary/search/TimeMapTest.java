package org.am.binary.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeMapTest {

    @Test
    void get() {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        assertEquals("", timeMap.get("asdfa", 1));
        assertEquals("bar", timeMap.get("foo", 1));
        assertEquals("bar", timeMap.get("foo", 2));
        assertEquals("", timeMap.get("foo", 0));
        timeMap.set("foo", "bar2", 5);
        assertEquals("bar2", timeMap.get("foo", 5));
        assertEquals("bar2", timeMap.get("foo", 6));
        assertEquals("bar", timeMap.get("foo", 4));


    }
}