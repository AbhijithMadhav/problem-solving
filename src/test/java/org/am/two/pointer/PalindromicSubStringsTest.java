package org.am.two.pointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PalindromicSubStringsTest {

    @Test
    void countSubstrings() {
        assertEquals(1, new PalindromicSubStrings().countSubstrings("a"));
        assertEquals(3, new PalindromicSubStrings().countSubstrings("aa"));
        assertEquals(6, new PalindromicSubStrings().countSubstrings("aaa"));
        assertEquals(7, new PalindromicSubStrings().countSubstrings("aaab"));
        assertEquals(9, new PalindromicSubStrings().countSubstrings("aaaba"));

    }
}