package org.am.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinTest {

    @Test
    void coinChange() {

        assertEquals(2, new Coin().coinChange(new int[]{1, 2, 3, 4, 5}, 6));
        assertEquals(2, new Coin().coinChange(new int[]{1, 2, 3, 4, 5}, 7));
        assertEquals(3, new Coin().coinChange(new int[]{1, 2, 5}, 11));
        assertEquals(0, new Coin().coinChange(new int[]{1, 2, 3, 4, 5}, 0));
        assertEquals(-1, new Coin().coinChange(new int[]{2, 4, 5}, 3));



    }
}