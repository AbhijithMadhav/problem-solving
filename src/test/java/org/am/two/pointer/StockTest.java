package org.am.two.pointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockTest {

    @Test
    void maxProfit() {
        Stock stock = new Stock();
        assertEquals(0, stock.maxProfit(new int[]{7}));
        assertEquals(0, stock.maxProfit(new int[]{7, 7, 7, 7}));
        assertEquals(5, stock.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(9, stock.maxProfit(new int[]{7, 1, 5, 3, 6, 10, 4}));
        //assertEquals(0, stock.maxProfit(new int[]{7, 5, 4, 1}));
    }
}