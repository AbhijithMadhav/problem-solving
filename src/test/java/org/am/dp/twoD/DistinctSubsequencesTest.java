package org.am.dp.twoD;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistinctSubsequencesTest {

    @Test
    void numDistinct() {
        assertEquals(3, new DistinctSubsequences().numDistinct("rabbbit", "rabbit"));
        assertEquals(5, new DistinctSubsequences().numDistinct("babgbag", "bag"));
    }
}