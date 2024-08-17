package org.am.hash;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/two-sum/">...</a>
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            map.putIfAbsent(num, new LinkedList<>());
            map.get(num).add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            int firstNum = nums[i];
            int secondNum = target - firstNum;
            if (map.containsKey(secondNum)) {
                if (secondNum != firstNum)
                    return new int[]{i, map.get(secondNum).getFirst()};
                else if (map.get(firstNum).size() > 1){
                    int finalI = i;
                    return new int[]{i , map.get(firstNum).stream().filter(index -> index != finalI).toList().getFirst()};
                }
            }
        }
        return null;
    }
}
