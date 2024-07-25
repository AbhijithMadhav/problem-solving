package org.am.graphs.dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/max-area-of-island/description/">...</a>
 */
public class MaxAreaIsland {

    private record Coordinate(int x, int y){}
    public int maxAreaOfIsland(int[][] grid) {
        Set<Coordinate> visited = new HashSet<>();
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && !visited.contains(new Coordinate(i, j))) {
                    int b = dfsArea(i, j, grid, visited);
                    max = Math.max(max, b);
                }
            }
        }
        return max;
    }

    private int dfsArea(int i, int j, int[][] grid, Set<Coordinate> visited) {
        visited.add(new Coordinate(i, j));
        int area = 1;
        if (i - 1 >= 0 && grid[i - 1][j] == 1 && !visited.contains(new Coordinate(i - 1, j)))
            area += dfsArea(i - 1, j, grid, visited);
        if (i + 1 < grid.length && grid[i + 1][j] == 1 && !visited.contains(new Coordinate(i + 1, j)))
            area += dfsArea(i + 1, j, grid, visited);
        if (j - 1 >= 0 && grid[i][j - 1] == 1 && !visited.contains(new Coordinate(i, j - 1)))
            area += dfsArea(i, j - 1, grid, visited);
        if (j + 1 < grid[i].length && grid[i][j + 1] == 1 && !visited.contains(new Coordinate(i, j + 1)))
            area += dfsArea(i, j + 1, grid, visited);
        return area;
    }


}
