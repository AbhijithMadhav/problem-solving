package org.am.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 * <a href="https://leetcode.com/problems/coin-change/description/">...</a>
 */
public class MinCoins {

    private final Map<Integer, Integer> cache = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin < 0)
                continue;
            int nCoins = nCoins(coins, amount - coin);
            if (nCoins == -1)
                continue;
            minCoins = Math.min(minCoins, 1 + nCoins);
        }
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    public int nCoins(int[] coins, int amount) {
        if (!cache.containsKey(amount))
            cache.put(amount, coinChange(coins, amount));
        return cache.get(amount);
    }
}
