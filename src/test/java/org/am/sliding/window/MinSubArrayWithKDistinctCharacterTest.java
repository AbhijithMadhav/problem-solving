package org.am.sliding.window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinSubArrayWithKDistinctCharacterTest {

    @Test
    void min() {
        MinSubArrayWithKDistinctCharacter obj = new MinSubArrayWithKDistinctCharacter();
        assertEquals("AH", obj.min("AAAHHIBC", 2));
        assertEquals("HIB", obj.min("AAAHHIBC", 3));
        //assertEquals("", obj.min("AAAHHIIIIIIIIIIBCCCCCCCCCCCC", 0));
        assertEquals("AH", obj.min("AAAHHIIIIIIIIIIBCCCCCCCCCCCC", 2));
        assertEquals("AHHI", obj.min("AAAHHIIIIIIIIIIBBCCCCCCCCCCCCGGF", 3));
        assertEquals("HIIIIIIIIIIBC", obj.min("AAAHHIIIIIIIIIIBCCCCCCCCCCCC", 4));
        assertEquals("AHHIIIIIIIIIIBC", obj.min("AAAHHIIIIIIIIIIBCCCCCCCCCCCC", 5));
        //assertEquals("", obj.min("AAAHHIIIIIIIIIIBCCCCCCCCCCCC", 6));
        assertEquals("ABC", obj.min("ABCD", 3));
    }
}