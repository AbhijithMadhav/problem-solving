package org.am.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxProductSubArrayTest {

    @Test
    void maxProduct() {

        assertEquals(1, new MaxProductSubArray().maxProduct(new int[] {-3,0,1,-2}));
        assertEquals(3, new MaxProductSubArray().maxProduct(new int[]{-3, -1, -1}));
        assertEquals(6, new MaxProductSubArray().maxProduct(new int[]{2, 3, -2, 4}));

    }
}