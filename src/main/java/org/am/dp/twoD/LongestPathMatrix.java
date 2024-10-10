package org.am.dp.twoD;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LongestPathMatrix {

    public int longestIncreasingPath(int[][] matrix) {
        int longest = 0;
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                longest = Math.max(longest, longestIncreasingPath(matrix, i, j));
        return longest;
    }

    private record Position(int i, int j){}
    private int longestIncreasingPath(int[][] matrix, int i, int j) {
        int longest = 1;
        List<Position> increasingNeighbours = increasingNeighbours(matrix[i][j], matrix, i, j);
        for (Position pos : increasingNeighbours)
            longest = Math.max(longest, 1 + longestPath(matrix, pos.i, pos.j));
        return longest;
    }

    private List<Position> increasingNeighbours(int val, int[][] matrix, int i, int j) {
        return Stream.of(new Position(i + 1, j), new Position(i - 1, j), new Position(i, j + 1), new Position(i, j - 1))
                .filter(pos -> pos.i < matrix.length && pos.j < matrix[0].length && pos.i >= 0 && pos.j >= 0)
                .filter(pos -> matrix[pos.i][pos.j] > val)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private final Map<Position, Integer> cache = new HashMap<>();
    private Integer longestPath(int[][] matrix, int i, int j) {
        Position key = new Position(i, j);
        if (!cache.containsKey(key))
            cache.put(key,longestIncreasingPath(matrix, i, j));
        return cache.get(key);
    }
}
