package org.am.dp;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordBreakTest {

    @Test
    void wordBreak() {
        assertTrue(new WordBreak().wordBreak("andog", List.of("an", "and", "og")));
        assertTrue(new WordBreak().wordBreak("applepenapple", List.of("apple", "pen")));
        assertFalse(new WordBreak().wordBreak("catsandog", List.of("cats", "and", "sand", "dog", "cat")));
    }
}