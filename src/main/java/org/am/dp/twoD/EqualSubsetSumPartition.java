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
public class EqualSubsetSumPartition {

    private record Key(int i, int sum){}
    private final Map<Key, Boolean> cache = new HashMap<>();
    private int hitCount = 0;
    private int terminationCount = 0;
    private int recursiveCallCount = 0;
    private int invocations = 0;

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0)
            return false;
        boolean b = cachedCanPartition(nums, 0, sum / 2) || cachedCanPartition(nums, 1, sum / 2);
        System.out.println("Solution space : " + sum * nums.length
                + ", cache size : " + cache.size()
                + ", invocations : " + invocations
                + ", % hit count : " + hitCount/(float)invocations * 100
                + ", % termination count : " + terminationCount/(float)invocations * 100
                + ", % recursive call count : " + recursiveCallCount/(float)invocations * 100
        );
        return b;
    }

    // Semantics : Can the number array be partitioned w.r.t including or not-including nums[i] to reach 'sum'
    private boolean cachedCanPartition(int[] nums, int i, int sum) {

        invocations++;
        if (i >= nums.length || sum < 0) {
            terminationCount++;
            //System.out.println("cachedCanPartition(" + i + ",  " + sum + ") : False" );
            return false;
        }

        if (sum == 0) {
            //System.out.println("cachedCanPartition(" + i + ",  " + sum + ") : True" );
            terminationCount++;
            return true;
        }

        Key key = new Key(i, sum);
        if (cache.containsKey(key)) {
            hitCount++;
            //System.out.println("cachedCanPartition(" + i + ",  " + sum + ") : Cached" );
            return cache.get(key);
        }

        recursiveCallCount++;
        //System.out.println("cachedCanPartition(" + i + ",  " + sum + ")");



        // if (sum - nums[i] > 0) {
        boolean canPartitionByIncludingIthElement = cachedCanPartition(nums, i + 1, sum - nums[i]);
        cache.put(new Key(i + 1, sum - nums[i]), canPartitionByIncludingIthElement);
        //}

        boolean canPartitionByNotIncludingIthElement = cachedCanPartition(nums, i + 1, sum);
        cache.put(new Key(i + 1, sum), canPartitionByNotIncludingIthElement);

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
