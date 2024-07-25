package org.am.graphs.dfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SurroundRegionsTest {

    @Test
    void solve() {
        char[][] board = {
                {'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        new SurroundRegions().solve(board);
        assertArrayEquals(
                new char[][]{
                        {'X','X','X','X'},{'X','X','X','X'},{'X','X','X','X'},{'X','O','X','X'}},
                board
        );
    }
}