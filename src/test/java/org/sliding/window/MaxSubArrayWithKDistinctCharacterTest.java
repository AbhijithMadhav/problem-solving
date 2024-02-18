package org.sliding.window;

import org.am.sliding.window.MaxSubArrayWithKDistinctCharacter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSubArrayWithKDistinctCharacterTest {

    @Test
    void max() {
        assertEquals("BCCCCCCCCCCCC", new MaxSubArrayWithKDistinctCharacter().max("AAAHHIIIIIIIIIIBCCCCCCCCCCCC", 2));

        assertEquals("AAAHH", new MaxSubArrayWithKDistinctCharacter().max("AAAHHIBC", 2));
        assertEquals("AAAHHI", new MaxSubArrayWithKDistinctCharacter().max("AAAHHIBC", 3));
        //assertEquals("", new MaxSubArrayWithKDistinctCharacter().max("AAAHHIIIIIIIIIIBCCCCCCCCCCCC", 0));
        assertEquals("IIIIIIIIIIBCCCCCCCCCCCC", new MaxSubArrayWithKDistinctCharacter().max("AAAHHIIIIIIIIIIBCCCCCCCCCCCC", 3));
        assertEquals("HHIIIIIIIIIIBCCCCCCCCCCCC", new MaxSubArrayWithKDistinctCharacter().max("AAAHHIIIIIIIIIIBCCCCCCCCCCCC", 4));
        assertEquals("AAAHHIIIIIIIIIIBCCCCCCCCCCCC", new MaxSubArrayWithKDistinctCharacter().max("AAAHHIIIIIIIIIIBCCCCCCCCCCCC", 5));
       // assertEquals("", new MaxSubArrayWithKDistinctCharacter().max("AAAHHIIIIIIIIIIBCCCCCCCCCCCC", 6));
        assertEquals("ABC", new MaxSubArrayWithKDistinctCharacter().max("ABCD", 3));



    }
}