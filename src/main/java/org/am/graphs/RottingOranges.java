package org.am.graphs;

import java.util.*;

public class RottingOranges {

    private boolean[][] visited;

    private record Orange(int x, int y){
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Orange that = (Orange) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    
    public int orangesRotting(int[][] grid) {
        visited = new boolean[grid.length][];

        for (int i = 0; i < visited.length; i++) {
            visited[i] = new boolean[grid[i].length];
            Arrays.fill(visited[i], false);
        }

        List<Orange> rottenOranges = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (visited[i][j] || grid[i][j] != 2)
                    continue;
                rottenOranges.add(new Orange(i, j));
            }
        }

        int steps = stepsToRot(grid, rottenOranges);

        for (int[] ints : grid)
            for (int val : ints)
                if (val == 1)
                    return -1;
        return steps;
    }

    private int stepsToRot(int[][] grid, List<Orange> rottenOranges) {
        Queue<Orange> queue = new LinkedList<>(rottenOranges);

        int steps = 0;
        while (!queue.isEmpty()) {

            // empty all contents to measure steps
            List<Orange> oranges = new LinkedList<>();
            while(!queue.isEmpty())
                oranges.add(queue.remove());

            if (rotNeighbors(grid, oranges, queue))
                steps++;
        }
        return steps;
    }

    private boolean rotNeighbors(int[][] grid, List<Orange> oranges, Queue<Orange> queue) {
        boolean madeRotten = false;
        for (Orange xy : oranges) {
            visited[xy.x][xy.y] = true;
            List<Orange> neighbors = getFreshNeigbours(grid, xy);
            for (Orange neighbor : neighbors) {
                if (grid[neighbor.x][neighbor.y] != 1)
                    continue;
                grid[neighbor.x][neighbor.y] = 2;
                madeRotten = true;
                queue.add(neighbor);
            }
        }
        return madeRotten;
    }

    private List<Orange> getFreshNeigbours(int[][] grid, Orange orange) {
        List<Orange> neighbors = new LinkedList<>();
        if (orange.x - 1 >= 0) {
            neighbors.add(new Orange(orange.x - 1, orange.y));
        }
        if (orange.y - 1 >= 0) {
            neighbors.add(new Orange(orange.x, orange.y - 1));
        }
        if (orange.x + 1 < grid.length) {
            neighbors.add(new Orange(orange.x + 1, orange.y));
        }
        if (orange.y + 1 < grid[0].length) {
            neighbors.add(new Orange(orange.x, orange.y + 1));
        }
        return neighbors;
    }
}
