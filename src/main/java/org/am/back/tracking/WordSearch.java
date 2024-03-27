package org.am.back.tracking;

import java.util.Arrays;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = new boolean[board[i].length];
            Arrays.fill(visited[i], false);
        }

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[i].length; j++)
                if (exist(board, word, i, j, visited))
                    return true;
        return false;
    }

    // Search for word starting at i, j
    private boolean exist(char[][] board, String word, int i, int j, boolean[][] visited) {
        if (visited[i][j])
            return false;

        if (board[i][j] == word.charAt(0)) {
            visited[i][j] = true;
            if (word.length() == 1)
                return true;
            if (j + 1 < board[i].length && exist(board, word.substring(1), i, j + 1, visited))
                return true;

            if (j - 1 >= 0 && exist(board, word.substring(1), i, j - 1, visited))
                return true;

            if (i + 1 < board.length && exist(board, word.substring(1), i + 1, j, visited))
                return true;

            if (i - 1 >= 0 && exist(board, word.substring(1), i - 1, j, visited))
                return true;
        }
        visited[i][j] = false;
        return false;
    }
}
