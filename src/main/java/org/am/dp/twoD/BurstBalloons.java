package org.am.dp.twoD;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/burst-balloons/">...</a>
 *
 */
public class BurstBalloons {

    public int maxCoins(int[] nums) {

        // crux
        int[] newNums = new int[nums.length + 2];
        newNums[0] = 1;
        newNums[newNums.length - 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, nums.length);

        return maxCoins(newNums, 1, newNums.length - 2);
    }

    private int maxCoins(int[] nums, int l, int r) {
        if (l > r)
            return 0;
        int maxCoins = 0;
        for (int i = l; i <= r; i++)
            maxCoins = Math.max(
                    maxCoins,
                    coins(nums, l, i - 1)
                            + (nums[l - 1] * nums[i] * nums[r + 1]) // crux
                            + coins(nums, i + 1, r)
            );
        return maxCoins;
    }

    private record Key(int l, int r){}
    private final Map<Key, Integer> cache = new HashMap<>();
    private int coins(int[] nums, int l, int r) {
        Key key = new Key(l, r);
        if (!cache.containsKey(key))
            cache.put(key, maxCoins(nums, l, r));
        return cache.get(key);
    }
}
