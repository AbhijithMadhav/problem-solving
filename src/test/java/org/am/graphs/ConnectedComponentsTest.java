package org.am.graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConnectedComponentsTest {

    @Test
    void connectedComponentsQF() {
        assertEquals(2, new ConnectedComponents().connectedComponentsQF(7, new int[][]{
                {1, 2}, {1, 4}, {2, 3}, {2, 4}, {0, 5}, {0, 6}, {5, 6}
        }));
        assertEquals(7, new ConnectedComponents().connectedComponentsQF(7, new int[][]{
        }));

        assertEquals(2, new ConnectedComponents().connectedComponentsQU(7, new int[][]{
                {1, 2}, {1, 4}, {2, 3}, {2, 4}, {0, 5}, {0, 6}, {5, 6}
        }));
        assertEquals(7, new ConnectedComponents().connectedComponentsQU(7, new int[][]{
        }));
    }
}