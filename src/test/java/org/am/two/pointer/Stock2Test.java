package org.am.two.pointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Stock2Test {

    @Test
    void maxProfit() {

        Stock2 stock = new Stock2();
        assertEquals(0, stock.maxProfit(new int[]{7}));
        assertEquals(0, stock.maxProfit(new int[]{7, 7, 7, 7}));
        assertEquals(7, stock.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(11, stock.maxProfit(new int[]{7, 1, 5, 3, 6, 10, 4}));
        assertEquals(4, stock.maxProfit(new int[]{1, 2, 3, 4, 5}));

    }
}