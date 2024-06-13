package org.am.dp.twoD;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount
 * representing a total amount of money.
 * Return the number of combinations that make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return 0.
 * You may assume that you have an infinite number of each kind of coin.
 * The answer is guaranteed to fit into a signed 32-bit integer.
 */
public class CoinChangeCount {

    private final Map<Key, Integer> cache = new HashMap<>();
    private record Key(int amount, int i) {}

    public int change(int amount, int[] coins) {
        if (amount == 0)
            return 1;
        return cachedChange(amount, coins, 0);
    }

    private int cachedChange(int amount, int[] coins, int i) {
        Key key = new Key(amount, i);
        if (!cache.containsKey(key))
            cache.put(key, change(amount, coins, i));
        return cache.get(key);
    }

    private int change(int amount, int[] coins, int i) {
        if (i >= coins.length || amount < 0)
            return 0;
        int count = 0;
        for (int j = i; j < coins.length; j++) {
            int coin = coins[j];
            if (amount - coin > 0)
                count += cachedChange(amount - coin, coins, j);
            else if (amount - coin == 0)
                count++;
        }
        return count;
    }
}
