package org.am.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JumpGame {

    private final Map<Integer, Boolean> canJump = new HashMap<>();

    public boolean canJump(int[] nums) {
        //return canJumpMemoizedWithArrayCopy(nums);
        //return canJumpMemoized(nums, nums.length - 1);
        return canJumpGreedy(nums);
    }

    // O9n^2
    private boolean canJumpMemoized(int[] nums, int lastIndex) {
        int length = lastIndex + 1;
        if (length > 1 && nums[0] < 1)
            return false;
        if (length <= 1)
            return true;

        if (canJump.containsKey(lastIndex))
            return canJump.get(lastIndex);
        for (int i = 0; i < lastIndex; i++) {
            if (nums[i] >= lastIndex - i) {
                canJump.put(i, canJumpMemoized(nums, i));
                if (canJump.get(i))
                    return true;
            }
        }
        return false;
    }
    public boolean canJumpMemoizedWithArrayCopy(int[] nums) {
        if (nums.length > 1 && nums[0] < 1)
            return false;
        if (nums.length <= 1)
            return true;

        if (canJump.containsKey(nums.length - 1))
            return canJump.get(nums.length - 1);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums.length - 1 - i) {
                canJump.put(i, canJumpMemoizedWithArrayCopy(Arrays.copyOfRange(nums, 0, i + 1)));
                if (canJump.get(i))
                    return true;
            }
        }
        return false;
    }

    // O(n)
    public boolean canJumpGreedy(int[] nums) {
        int targetIndex = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= targetIndex - i)
                targetIndex = i;
        }
        return targetIndex == 0;
    }
}
