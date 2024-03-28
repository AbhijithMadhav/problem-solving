package org.am.two.pointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestPalindromeTest {

    @Test
    void longestPalindromicSubstring() {

        LongestPalindrome lps = new LongestPalindrome();
        // even palindrome
        assertEquals("asdffdsa", lps.longestPalindrome("asdfkjaasdffdsakjdf"));
        assertEquals("asdffdsa", lps.longestPalindrome("asdffdsakjdf"));
        assertEquals("asdffdsa", lps.longestPalindrome("asdfkjaasdffdsa"));
        assertEquals("asdffdsa", lps.longestPalindrome("abasdfkjaasdffdsa"));

        // odd palindrome
        assertEquals("asdfdsa", lps.longestPalindrome("asdfkjaasdfdsakjdf"));
        assertEquals("i", lps.longestPalindrome("ihfgalkjgadbv"));
    }
}