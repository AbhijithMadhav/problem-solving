package org.am.dp.twoD;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StocksWithCooldownTest {

    @Test
    void maxProfit() {
        assertEquals(3, new StocksWithCooldown().maxProfit(new int[]{1, 2, 3, 0, 2}));
        assertEquals(0, new StocksWithCooldown().maxProfit(new int[]{1}));
    }
}