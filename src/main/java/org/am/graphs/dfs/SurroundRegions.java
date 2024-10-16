package org.am.graphs.dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/surrounded-regions/">...</a>
 */
public class SurroundRegions {

    private record Coordinate(int x, int y){}
    Set<Coordinate> visited = new HashSet<>();

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++) {
                // Crux : Anything connected to a border '0' can't be conquered
                // So discover all those cells via a traversal
                if (board[i][j] == 'O' && (i == board.length - 1 || j == board[i].length - 1 || i == 0 || j == 0))
                    dfsSave(board, i, j);
            }

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'S')
                    board[i][j] = 'O';
            }
    }

    private void dfsSave(char[][] board, int x, int y) {
        board[x][y] = 'S';
        visited.add(new Coordinate(x, y));
        for (int[] xy : new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
            if (shouldTraverse(board, x + xy[0], y + xy[1])) {
                dfsSave(board, x + xy[0], y + xy[1]);
            }
        }
    }

    private boolean shouldTraverse(char[][] board, int x, int y) {
        return x >= 0 && x < board.length
                && y >= 0 && y < board[x].length
                && board[x][y] == 'O'
                && !visited.contains(new Coordinate(x, y));
    }
}
