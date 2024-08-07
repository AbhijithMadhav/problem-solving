package org.am.sliding.window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSubStringWithDistinctCharactersTest {

    @Test
    void lengthOfLongestSubstring() {
        MaxSubStringWithDistinctCharacters obj = new MaxSubStringWithDistinctCharacters();
        assertEquals(0, obj.lengthOfLongestSubstring(""));
        assertEquals(1, obj.lengthOfLongestSubstring("aaaaa"));
        assertEquals(3, obj.lengthOfLongestSubstring("abcabc"));
        assertEquals(12, obj.lengthOfLongestSubstring("asdfhjknaskldfhjuoghnalsdvbj"));
    }
}