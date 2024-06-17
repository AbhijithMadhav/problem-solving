package org.am.sliding.window;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxSubStringWithKDistinctCharactersTest {

    @Test
    void max() {
        assertEquals("BCCCCCCCCCCCC", new MaxSubStringWithKDistinctCharacters().max("AAAHHIIIIIIIIIIBCCCCCCCCCCCC", 2));

        assertEquals("AAAHH", new MaxSubStringWithKDistinctCharacters().max("AAAHHIBC", 2));
        assertEquals("AAAHHI", new MaxSubStringWithKDistinctCharacters().max("AAAHHIBC", 3));
        //assertEquals("", new MaxSubArrayWithKDistinctCharacter().max("AAAHHIIIIIIIIIIBCCCCCCCCCCCC", 0));
        assertEquals("IIIIIIIIIIBCCCCCCCCCCCC", new MaxSubStringWithKDistinctCharacters().max("AAAHHIIIIIIIIIIBCCCCCCCCCCCC", 3));
        assertEquals("HHIIIIIIIIIIBCCCCCCCCCCCC", new MaxSubStringWithKDistinctCharacters().max("AAAHHIIIIIIIIIIBCCCCCCCCCCCC", 4));
        assertEquals("AAAHHIIIIIIIIIIBCCCCCCCCCCCC", new MaxSubStringWithKDistinctCharacters().max("AAAHHIIIIIIIIIIBCCCCCCCCCCCC", 5));
       // assertEquals("", new MaxSubArrayWithKDistinctCharacter().max("AAAHHIIIIIIIIIIBCCCCCCCCCCCC", 6));
        assertEquals("ABC", new MaxSubStringWithKDistinctCharacters().max("ABCD", 3));



    }
}