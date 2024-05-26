package org.am.dp.twoD;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringInterleavingTest {

    @Test
    void isInterleave() {
        assertFalse(new StringInterleaving().isInterleave("", "abc", "ab"));

        assertFalse(new StringInterleaving().isInterleave("a", "b", "a"));

        assertTrue(new StringInterleaving().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        assertFalse(new StringInterleaving().isInterleave("aabc", "dbbca", "aadbbcbcac"));
        assertFalse(new StringInterleaving().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        assertTrue(new StringInterleaving().isInterleave("", "", ""));

    }
}