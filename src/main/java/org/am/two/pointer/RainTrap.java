package org.am.two.pointer;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 */
public class RainTrap {

    // Crux is to recognized that water for each position can be calculated iteratively
    // The amount of water that can be stored at a position is determined by the extent of the walls on its left and right
    // Not just the immediate walls. But the maximum heighted wall on its left and right. This is the absolute key
    // This leads to the calculation of the max heights on either side for each position.
    // The other, easier, realization is that, more specifically, the amount of water that can be held is determined by the smaller of the two walls
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
            if (heights[i] < leftMax[i] && heights[i] < rightMax[i]) // Important : If either of the walls are shorter than the one at position i water can't be stored
                area += Math.min(leftMax[i], rightMax[i]) - heights[i];
        }
        return area;
    }


    // Optimized version which does not utlize extra space
    // The area at a position is determined by the smaller of its left or right wall. This has been discovered above
    // If we iterate to a position from the left we will know the maximum left wall. We will not know the max right wall
    // Similarly if we iterate to a position from the right we will know the maximum right wall and not know the max left
    // So how do we know about the max walls on both the left and right if we don't store them?
    // The answer is that we don't need to know about both since the area is determined by the smaller wall.
    // Consider iterating to a position from the left
    // What if we know of the maximum right for some other position j(j > i)?
    // We can do this by using the two pointer technique and iterating from the right simultaneously
    // if the maxLeft for i is smaller than the max right for j what can we conclude?
    // We can conclude that the water trapped at i is determined by maxLeft for i
    // as the max right for i(which is not yet known) will be atleast equal if not greater than the max right for j
    // if maxLeft for i is bigger, then its the opposite.
    // We can conclude that the water trapped at j is determined by maxRight of j
    // as the max left for j(which is not yet knownd) will be atleast equal if not greater than the max left for i
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
