package org.am.dp.twoD;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonSubsequenceTest {

    @Test
    void longestCommonSubsequence() {
        assertEquals(3, new CommonSubsequence().longestCommonSubsequence("abcde", "ace"));
        assertEquals(3, new CommonSubsequence().longestCommonSubsequence("abc", "abc"));
        assertEquals(0, new CommonSubsequence().longestCommonSubsequence("abcde", "fgh"));
    }
}