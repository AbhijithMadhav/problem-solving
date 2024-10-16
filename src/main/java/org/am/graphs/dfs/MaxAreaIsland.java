package org.am.graphs.dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/max-area-of-island/description/">...</a>
 */
public class MaxAreaIsland {

    private record Coordinate(int x, int y){}
    Set<Coordinate> visited = new HashSet<>();

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !visited.contains(new Coordinate(i, j))) {
                    int b = dfsArea(i, j, grid);
                    max = Math.max(max, b);
                }
            }
        }
        return max;
    }

    private int dfsArea(int i, int j, int[][] grid) {
        visited.add(new Coordinate(i, j));
        int area = 1;

        for (int[] xy : new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
            if (shouldTraverse(grid, i + xy[0], j + xy[1])) {
                area += dfsArea(i + xy[0], j + xy[1], grid);
            }
        }
        return area;
    }

    private boolean shouldTraverse(int[][] grid, int x, int y) {
        return x >= 0 && x < grid.length
                && y >= 0 && y < grid[x].length
                && grid[x][y] == 1
                && !visited.contains(new Coordinate(x, y));
    }


}
