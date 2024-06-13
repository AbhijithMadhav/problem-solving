package org.am.sliding.window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithReplacementTest {

    @Test
    void characterReplacement() {
        assertEquals(4, new LongestSubstringWithReplacement().characterReplacement("ABAA", 1));
        assertEquals(5, new LongestSubstringWithReplacement().characterReplacement("ABABA", 2));
        assertEquals(4, new LongestSubstringWithReplacement().characterReplacement("ABAB", 2));
        assertEquals(4, new LongestSubstringWithReplacement().characterReplacement("AABABBA", 1));
        assertEquals(7, new LongestSubstringWithReplacement().characterReplacement("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4));
    }
}