package org.others;

import org.am.dp.RE;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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