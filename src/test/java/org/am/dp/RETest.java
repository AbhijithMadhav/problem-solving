package org.am.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RETest {

    @Test
    public void match() {

        assertFalse(new RE().isMatch("aa", "a"));

        assertTrue(new RE().isMatch("a", "a*"));

        assertTrue(new RE().isMatch("aaab", "a*b*"));
        assertTrue(new RE().isMatch("aaab", "a*b"));
        assertFalse(new RE().isMatch("aaa", "a*b"));
        assertTrue(new RE().isMatch("aaaaaaaaaa", "a*"));
        assertTrue(new RE().isMatch("", "a*"));



    }

}