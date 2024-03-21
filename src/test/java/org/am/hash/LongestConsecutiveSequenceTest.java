package org.am.hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestConsecutiveSequenceTest {

    @Test
    void longestConsecutive() {

        assertEquals(4, new LongestConsecutiveSequence().longestConsecutive(new int[]{100, 4, 200, 3, 1, 2}));
        assertEquals(9, new LongestConsecutiveSequence().longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));

    }
}