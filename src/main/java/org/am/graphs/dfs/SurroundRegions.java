package org.am.graphs.dfs;

import java.util.HashSet;
import java.util.Set;

public class SurroundRegions {

    private record Coordinate(int x, int y){}

    public void solve(char[][] board) {
        Set<Coordinate> visited = new HashSet<>();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O' && (i == board.length - 1 || j == board[i].length - 1 || i == 0 || j == 0))
                    dfsSave(board, i, j, visited);
            }

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'S')
                    board[i][j] = 'O';
            }
    }

    private void dfsSave(char[][] board, int x, int y, Set<Coordinate> visited) {
        board[x][y] = 'S';
        visited.add(new Coordinate(x, y));
        if (x - 1 >= 0 && board[x - 1][y] == 'O' && !visited.contains(new Coordinate(x - 1, y)))
            dfsSave(board, x - 1, y, visited);
        if (x + 1 < board.length && board[x + 1][y] == 'O' && !visited.contains(new Coordinate(x + 1, y)))
            dfsSave(board, x + 1, y, visited);
        if (y - 1 >= 0 && board[x][y - 1] == 'O' && !visited.contains(new Coordinate(x, y - 1)))
            dfsSave(board, x, y - 1, visited);
        if (y + 1 < board[0].length && board[x][y + 1] == 'O' && !visited.contains(new Coordinate(x, y + 1)))
            dfsSave(board, x, y + 1, visited);
    }
}
