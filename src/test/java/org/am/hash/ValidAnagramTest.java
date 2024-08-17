package org.am.hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidAnagramTest {

    @Test
    void isAnagram() {
        assertFalse(new ValidAnagram().isAnagram("rat", "car"));
    }
}