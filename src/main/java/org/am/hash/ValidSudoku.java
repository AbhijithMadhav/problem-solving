package org.am.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.' && set.contains(board[i][j]))
                    return false;
                set.add(board[i][j]);
            }

            set = new HashSet<>();
            for (char[] chars : board) {
                if (chars[i] != '.' && set.contains(chars[i]))
                    return false;
                set.add(chars[i]);
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Set<Character> set = new HashSet<>();
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        if (board[x][y] != '.' && set.contains(board[x][y]))
                            return false;
                        set.add(board[x][y]);
                    }
                }
            }
        }

        return true;
    }
}
