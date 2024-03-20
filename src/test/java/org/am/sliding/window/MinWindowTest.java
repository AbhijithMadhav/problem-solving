package org.am.sliding.window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinWindowTest {

    @Test
    void minWindow() {

        assertEquals("aa", new MinWindow().minWindow("aa", "aa"));

        assertEquals("BANC", new MinWindow().minWindow("ADOBECODEBANC", "ABC"));
        assertEquals("a", new MinWindow().minWindow("a", "a"));
        assertEquals("", new MinWindow().minWindow("a", "aa"));
        assertEquals("BANC", new MinWindow().minWindow("AADOBECODEBANC", "ABC"));
    }
}