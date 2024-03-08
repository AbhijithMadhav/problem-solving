package org.am.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 */
public class Coin {

    private final Map<Integer, Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;
        if (map.containsKey(amount))
            return map.get(amount);

        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin >= 0) {
                map.putIfAbsent(amount - coin, coinChange(coins, amount - coin));
                if (map.get(amount - coin) == -1)
                    continue;
                minCoins = Math.min(minCoins, 1 + map.get(amount - coin));
            }
        }
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }
}
