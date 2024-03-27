package org.am.back.tracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordSearchTest {

    @Test
    void exist() {

        char[][] board = new char[3][4];
        board[0] = new char[] {'A', 'B', 'C', 'E'};
        board[1] = new char[] {'S', 'F', 'C', 'S'};
        board[2] = new char[] {'A', 'D', 'E', 'E'};

        //assertTrue(new WordSearch().exist(board, "ECCFDA"));
        //assertFalse(new WordSearch().exist(board, "ECCHHHFDA"));
        assertFalse(new WordSearch().exist(board, "ABA"));


    }
}