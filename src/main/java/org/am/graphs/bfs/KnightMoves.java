package org.am.graphs.bfs;

import java.util.*;

/**
 * <a href="https://leetcode.ca/all/1197.html">...</a>
 */
public class KnightMoves {

    private record Position(int x, int y) {}

    private final Set<Position> visited = new HashSet<>();

    public int minKnightMoves(int[][] board, int[] target) {
        Position targetPos = new Position(target[0], target[1]);
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(0, 0));
        int moves = 0;
        while (!queue.isEmpty()) {
            List<Position> nextPositions = new LinkedList<>();
            while (!queue.isEmpty()) {
                Position position = queue.remove();
                visited.add(position);
                if (position.equals(targetPos))
                    return moves;
                nextPositions.addAll(getNextPositions(board, position));
            }
            queue.addAll(nextPositions);
            moves++;
        }
        return moves;
    }

    private List<Position> getNextPositions(int[][] board, Position position) {
        int[][] directions = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
        List<Position> positions = new LinkedList<>();
        int x = position.x;
        int y = position.y;

        for (int[] direction : directions) {
            Position newPosition = new Position(x + direction[0], y + direction[1]);
            if (x + direction[0] >=0 && x + direction[0] < board.length
                    && y + direction[1] >= 0 && y + direction[1] < board[0].length
                    && !visited.contains(newPosition)
            )
                positions.add(newPosition);
        }
        return positions;
    }
}
