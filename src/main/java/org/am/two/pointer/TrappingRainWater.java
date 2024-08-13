package org.am.two.pointer;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 * <a href="https://leetcode.com/problems/trapping-rain-water/description/">...</a>
 */
public class TrappingRainWater {

    public int trapWithExtraSpace(int[] heights) {

        int[] leftMax = new int[heights.length];
        int max = 0;
        for (int i = 0 ; i < heights.length; i++) {
            leftMax[i] = max;
            max = Math.max(heights[i], max);
        }

        int[] rightMax = new int[heights.length];
        max = 0;
        for (int i = heights.length - 1 ; i >= 0; i--) {
            rightMax[i] = max;
            max = Math.max(heights[i], max);
        }

        int area = 0;
        for (int i = 0 ; i < heights.length; i++) {
            if (heights[i] < leftMax[i] && heights[i] < rightMax[i]) // Important:
                // If either of the walls is shorter than the one at position i,
                // water can't be stored
                area += Math.min(leftMax[i], rightMax[i]) - heights[i];
        }
        return area;
    }

    public int trap(int[] heights) {
        int maxLeft = heights[0];
        int maxRight = heights[heights.length - 1];
        int l = 0, r = heights.length - 1;
        int area = 0;
        while (l < r) {
            maxLeft = Math.max(maxLeft, heights[l]);
            maxRight = Math.max(maxRight, heights[r]);
            if (maxLeft < maxRight) {
                area += maxLeft - heights[l];
                l++;
            }  else {
                area += maxRight - heights[r];
                r--;
            }
        }
        return area;
    }
}
