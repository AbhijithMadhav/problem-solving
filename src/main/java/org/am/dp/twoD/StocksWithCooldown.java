package org.am.dp.twoD;

import java.util.*;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:
 * After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 */
public class StocksWithCooldown {

    private final Map<Key, Integer> cache = new HashMap<>();
    public int maxProfit(int[] prices) {
        return cachedMaxProfit(prices, 0, true);
    }

    // This is a good practice from a code structuring perspective
    private int cachedMaxProfit(int[] prices, int i, boolean buy) {
        Key key = new Key(i, buy);
        if (!cache.containsKey(key))
            cache.put(key, maxProfit(prices, i, buy));
        return cache.get(key);
    }

    // max profit when bought/cooldown or sold/cooldown on the ith day
    private int maxProfit(int[] prices, int i, boolean buy) {
        if (i >= prices.length)
            return 0;
        if (buy) {
            return Math.max(
                    -prices[i] + cachedMaxProfit(prices, i + 1, false), // buy today and sell tomorrow
                    cachedMaxProfit(prices, i + 1, true) // cooldown and buy tomorrow
            );
        } else {
            return Math.max(
                    prices[i] + cachedMaxProfit(prices, i + 2, true), // sell today and buy the day after tomorrow
                    cachedMaxProfit(prices, i + 1, false) // cooldown and sell tomorrow
            );
        }
    }

    private record Key(int i, boolean buy){
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return i == key.i && buy == key.buy;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, buy);
        }
    }
}
