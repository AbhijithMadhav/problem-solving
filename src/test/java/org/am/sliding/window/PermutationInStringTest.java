package org.am.sliding.window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermutationInStringTest {

    @Test
    void permutationInString() {
        assertTrue(new PermutationInString().checkInclusion("aba", "adsfasdfbaaooo"));
        assertTrue(new PermutationInString().checkInclusion("ab", "adsfasdfbaooo"));
        assertTrue(new PermutationInString().checkInclusion("ab", "ab"));
        assertTrue(new PermutationInString().checkInclusion("adc", "dcda"));

    }
}