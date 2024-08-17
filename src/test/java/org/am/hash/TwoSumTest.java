package org.am.hash;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    @Test
    void twoSum() {
        assertArrayEquals(new int[]{1, 2}, new TwoSum().twoSum(new int[]{3, 2, 4}, 6));
    }
}