package org.am.dp.twoD;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinChangeCountTest {

    @Test
    void change() {
        assertEquals(4, new CoinChangeCount().change(5, new int[]{1, 2, 5}));
        assertEquals(0, new CoinChangeCount().change(3, new int[]{2}));
    }
}