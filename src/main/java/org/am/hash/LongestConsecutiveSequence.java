package org.am.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 */
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        int maxSequenceLength = 0;
        for (int num : nums) {
            // removing an element which is a part of the sequence avoids computation
            map.computeIfPresent(num, (k, v) -> v > 1 ? v - 1 : null);

            int sequenceCount = 1;

            // The crux of the solution
            // Whether a number is a part of a larger sequence can be done using a hashmap

            // check for previous nums
            int sequenceMember = num - 1;
            while (map.containsKey(sequenceMember)) {
                map.computeIfPresent(sequenceMember, (k, v) -> v > 1 ? v - 1 : null);
                sequenceMember = sequenceMember - 1;
                sequenceCount++;
            }

            // check for next nums
            sequenceMember = num + 1;
            while (map.containsKey(sequenceMember)) {
                map.computeIfPresent(sequenceMember, (k, v) -> v > 1 ? v - 1 : null);
                sequenceMember = sequenceMember + 1;
                sequenceCount++;
            }
            maxSequenceLength = Math.max(maxSequenceLength, sequenceCount);
        }
        return maxSequenceLength;
    }
}
