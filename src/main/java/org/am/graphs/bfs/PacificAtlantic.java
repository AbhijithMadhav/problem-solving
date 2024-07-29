package org.am.graphs.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/pacific-atlantic-water-flow/description/">...</a>
 */
public class PacificAtlantic {


    private record Coordinate(int x, int y){}

    // Trying to find the flow of water from every vertex to the oceans implies bfs from every vertex
    // Instead reverse bfs from the ocean edges as source vertices is O((r + c) * n) instead of O(n^2)
    public List<List<Integer>> pacificAtlantic(int[][] grid) {

        boolean[][] pacificVisited = intializeVisited(grid);

        // For all Pacific adjacent nodes
        List<Coordinate> sourceVerticies = new LinkedList<>();
        for (int x = 0; x < grid.length; x++)
            sourceVerticies.add(new Coordinate(x, 0));
        for (int y = 1; y < grid[0].length; y++)
            sourceVerticies.add(new Coordinate(0, y));
        bfs(grid, pacificVisited, sourceVerticies);

        // Atlantic
        sourceVerticies = new LinkedList<>();
        boolean[][] atlanticVisited = intializeVisited(grid);
        for (int x = 0; x < grid.length; x++)
            sourceVerticies.add(new Coordinate(x, grid[0].length - 1));
        for (int y = 0; y < grid[0].length - 1; y++)
            sourceVerticies.add(new Coordinate(grid.length - 1, y));
        bfs(grid, atlanticVisited, sourceVerticies);


        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (atlanticVisited[i][j] && pacificVisited[i][j])
                    result.add(List.of(i, j));
            }
        }
        return result;
    }

    private static boolean[][] intializeVisited(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][];

        for (int i = 0; i < grid.length; i++) {
            visited[i] = new boolean[grid[i].length];
            Arrays.fill(visited[i], false);
        }
        return visited;
    }

    private void bfs(int[][] grid, boolean[][] visited, List<Coordinate> startVerticies) {
        Queue<Coordinate> queue = new LinkedList<>(startVerticies);
        while (!queue.isEmpty()) {
           Coordinate c = queue.remove();
           if (visited[c.x][c.y])
               continue;
           visited[c.x][c.y] = true;
           queue.addAll(getValidNeighbours(c.x, c.y, grid, visited));
        }
    }

    private List<Coordinate> getValidNeighbours(int i, int j, int[][] grid,  boolean[][] visited) {
       List<Coordinate> neighbours = new LinkedList<>();
        if (i - 1 >= 0 && !visited[i - 1][j] && grid[i-1][j] >= grid[i][j])
            neighbours.add(new Coordinate(i - 1, j));
        if (j - 1 >=0 && !visited[i][j - 1] && grid[i][j-1] >= grid[i][j])
            neighbours.add(new Coordinate(i, j - 1));
        if (i+1 < grid.length && !visited[i + 1][j] && grid[i+1][j] >= grid[i][j])
            neighbours.add(new Coordinate(i + 1, j));
        if (j + 1 < grid[i].length && !visited[i][j + 1] && grid[i][j+1] >= grid[i][j])
            neighbours.add(new Coordinate(i, j + 1));
        return neighbours;
    }
}