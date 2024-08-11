package org.am.graphs.bfs;

import java.util.*;
import java.util.stream.Stream;

/**
 * <a href="https://leetcode.com/problems/walls-and-gates/description/">...</a>
 * You are given a m × n
 * m×n 2D grid initialized with these three possible values:
 * -1 - A water cell that can not be traversed.
 * 0 - A treasure chest.
 * INF - A land cell that can be traversed. We use the integer 2^31 - 1 = 2147483647 to represent INF.
 * Fill each land cell with the distance to its nearest treasure chest. If a land cell cannot reach a treasure chest than the value should remain INF
 * Assume the grid can only be traversed up, down, left, or right.
 */
public class IslandsAndTreasures {

    record Cell(int x, int y){}

    public void islandsAndTreasure(int[][] grid) {
        Queue<Cell> queue = new LinkedList<>();
        for (int x = 0; x < grid.length; x++)
            for (int y = 0; y < grid[0].length; y++)
                if (grid[x][y] == 0)
                    queue.add(new Cell(x, y));

        Set<Cell> visited = new HashSet<>();
        int distance = 0;
        while(!queue.isEmpty()) {
            // Process all neighbors together to mark their distance from the treasure cells
            List<Cell> cells = queue.stream().toList();
            queue.clear();
            visited.addAll(cells);
            List<Cell> allNeighbours = cells.stream()
                    .map(cell -> neighboringLandCells(cell, grid))
                    .flatMap(Collection::stream)
                    .toList();
            distance++;
            for (Cell neighbor : allNeighbours) {
                // a neighboring land cell marked with a distance means that it is nearer to some other treasure cell
                // than the one this path is from
                if (!visited.contains(neighbor) && grid[neighbor.x][neighbor.y] == Integer.MAX_VALUE) {
                    grid[neighbor.x][neighbor.y] = distance;
                    queue.add(neighbor);
                }
            }
        }
    }

    private List<Cell> neighboringLandCells(Cell cell, int[][] grid) {
        int x = cell.x;
        int y = cell.y;
        return Stream.of(new Cell( x + 1, y), new Cell(x - 1, y), new Cell(x, y + 1), new Cell(x, y - 1))
                .filter(c -> c.x >= 0 && c.x < grid.length && c.y >= 0 && c.y < grid[0].length)
                .toList();
    }
}
