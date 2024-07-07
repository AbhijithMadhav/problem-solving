package org.am.dp.twoD;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the
 * elements in both subsets is equal or false otherwise.
 * Constraints:
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class SubsetSumPartition {

    private record Key(int i, int sum){}
    private final Map<Key, Boolean> cache = new HashMap<>();

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0)
            return false;
        return cachedCanPartition(nums, 0, sum / 2) || cachedCanPartition(nums, 1, sum / 2);
    }

    private boolean cachedCanPartition(int[] nums, int i, int sum) {

        Key key = new Key(i, sum);
        if (cache.containsKey(key))
            return cache.get(key);

        if (sum == 0)
            return true;
        if (i >= nums.length || sum < 0)
            return false;

        boolean canPartitionByNotIncludingIthElement = cachedCanPartition(nums, i + 1, sum);
        cache.put(new Key(i + 1, sum), canPartitionByNotIncludingIthElement);

       // if (sum - nums[i] > 0) {
        boolean canPartitionByIncludingIthElement = cachedCanPartition(nums, i + 1, sum - nums[i]);
        cache.put(new Key(i + 1, sum - nums[i]), canPartitionByIncludingIthElement);
        //}

        return canPartitionByIncludingIthElement || canPartitionByNotIncludingIthElement;
    }

    private boolean canPartition(int[] nums, int i, int sum) {

        if (sum == 0)
            return true;
        if (i >= nums.length || sum < 0)
            return false;

        return canPartition(nums, i + 1, sum - nums[i])
                || canPartition(nums, i + 2, sum - nums[i]);
    }
}
