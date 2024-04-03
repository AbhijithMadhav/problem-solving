package org.am.dp.twoD;

import java.util.Arrays;

/**
 * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time
 * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
 */
public class UniquePaths {


    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];
        for (int[] c : cache)
            Arrays.fill(c, -1);
        return uniquePaths(0, 0, m, n, cache);
    }

    private int uniquePaths(int x, int y, int m, int n, int[][] cache) {

        if(cache[x][y] != - 1)
            return cache[x][y];

        if (x == m - 1 && y == n - 1)
            return 1;

        int downCount = x + 1 < m ? uniquePaths(x + 1, y, m, n, cache) : 0;
        int rightCount = y + 1 < n ? uniquePaths(x, y + 1, m, n, cache) : 0;
        cache[x][y] = rightCount + downCount;
       return cache[x][y];
    }
}
