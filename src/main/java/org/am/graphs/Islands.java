package org.am.graphs;

import java.util.*;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class Islands {

    private record V(int x, int y) {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            V v = (V) o;
            return x == v.x && y == v.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


    public int numIslands(char[][] grid) {
        //return getNumConnectedComponents(getAdjMap(grid));
        Set<V> visited = new HashSet<>();
        int count = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                V v = new V(x, y);
                if (grid[x][y] == '0' || visited.contains(v))
                    continue;
                Deque<V> stack = new LinkedList<>();
                stack.push(v);
                while (!stack.isEmpty()) {
                    V s = stack.pop();
                    visited.add(s);
                    int i = s.x;
                    int j = s.y;
                    if (i - 1 >= 0 && grid[i - 1][j] == '1' && !visited.contains(new V(i - 1, j)))
                        stack.push(new V(i - 1, j));
                    if (i + 1 < grid.length && grid[i + 1][j] == '1'  && !visited.contains(new V(i + 1, j)))
                        stack.push(new V(i + 1, j));
                    if (j - 1 >= 0 && grid[i][j - 1] == '1'  && !visited.contains(new V(i, j - 1)))
                        stack.push(new V(i, j - 1));
                    if (j + 1 < grid[i].length && grid[i][j + 1] == '1'  && !visited.contains(new V(i, j + 1)))
                        stack.push(new V(i, j + 1));
                }
                count++;
            }
        }
        return count;
    }
}
