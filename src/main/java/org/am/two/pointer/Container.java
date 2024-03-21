package org.am.two.pointer;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 */
public class Container {

    public int maxArea(int[] height) {
        int max = 0;
        for (int l = 0, r = height.length - 1; l < r;) {
            max = Math.max(max, (r - l) * Math.min(height[r], height[l]));

            // This is the crux of the solution
            // Since height[l] is lesser of the two moving r would definitely decrease the volume of the container
            // Moving l might increase or decrease the volume depending on how high l+1 is
            // So we move l to eliminate the obvious. This is the greedy choice
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return max;
    }
}
