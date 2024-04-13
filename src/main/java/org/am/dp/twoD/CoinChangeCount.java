package org.am.dp.twoD;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CoinChangeCount {

    private final Map<Key, Integer> cache = new HashMap<>();
    private record Key(int amount, int i){
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return amount == key.amount && i == key.i;
        }

        @Override
        public int hashCode() {
            return Objects.hash(amount, i);
        }
    }

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
