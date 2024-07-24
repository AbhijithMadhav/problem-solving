package org.am.graphs.bfs;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/rotting-oranges/description/">...</a>
 */
public class RottingOranges {


    private record Orange(int x, int y){}
    
    public int orangesRotting(int[][] grid) {

        int stepsToRot = multiSourceBFS(grid, getRottenOranges(grid));

        return checkForFreshOranges(grid) ? -1 : stepsToRot;
    }

    private static List<Orange> getRottenOranges(int[][] grid) {
        List<Orange> rottenOranges = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 2)
                    continue;
                rottenOranges.add(new Orange(i, j));
            }
        }
        return rottenOranges;
    }

    // Crux is that bfs and not dfs simulates the rotting of neighbouring oranges
    // Also multisource bfs is required
    private static int multiSourceBFS(int[][] grid, List<Orange> rottenOranges) {
        Queue<Orange> queue = new LinkedList<>(rottenOranges);

        int steps = 0;
        while (!queue.isEmpty()) {

            List<Orange> oranges = new LinkedList<>(queue);
            queue.clear();

            boolean madeRotten = false;
            for (Orange o : oranges) {
                List<Orange> neighbors = getFreshNeighbours(grid, o);
                for (Orange fo : neighbors) {
                    grid[fo.x][fo.y] = 2;
                    madeRotten = true;
                    queue.add(fo);
                }
            }
            if (madeRotten)
                steps++;
        }
        return steps;
    }

    private static List<Orange> getFreshNeighbours(int[][] grid, Orange o) {
        List<Orange> neighbors = new LinkedList<>();
        if (o.x - 1 >= 0 && grid[o.x - 1][o.y] == 1)
            neighbors.add(new Orange(o.x - 1, o.y));
        if (o.y - 1 >= 0 && grid[o.x][o.y - 1] == 1)
            neighbors.add(new Orange(o.x, o.y - 1));
        if (o.x + 1 < grid.length && grid[o.x + 1][o.y] == 1)
            neighbors.add(new Orange(o.x + 1, o.y));
        if (o.y + 1 < grid[0].length && grid[o.x][o.y + 1] == 1)
            neighbors.add(new Orange(o.x, o.y + 1));
        return neighbors;
    }

    private static boolean checkForFreshOranges(int[][] grid) {
        for (int[] ints : grid)
            for (int val : ints)
                if (val == 1)
                    return true;
        return false;
    }
}
