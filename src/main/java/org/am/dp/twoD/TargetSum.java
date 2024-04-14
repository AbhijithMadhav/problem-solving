package org.am.dp.twoD;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * You are given an integer array nums and an integer target.
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 */
public class TargetSum {

    private record Pair(int start, int target) {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return start == pair.start && target == pair.target;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, target);
        }
    }

    private final Map<Pair, Integer> cache = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        return cachedWrapper(nums, 0 , target);
    }

    private int cachedWrapper(int[] nums, int start, int target) {
        Pair key = new Pair(start, target);
        if (!cache.containsKey(key))
            cache.put(key, findTargetSumWaysStartingFromPositionStart(nums, start, target));
        return cache.get(key);
    }

    private int findTargetSumWaysStartingFromPositionStart(int[] nums, int start, int target) {
        if (start == nums.length)
            return target == 0 ? 1 : 0;

        return cachedWrapper(nums, start + 1, target - nums[start])
                + cachedWrapper(nums, start + 1, target + nums[start]);
    }
}
