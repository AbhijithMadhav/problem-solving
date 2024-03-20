package org.am.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobberTest {

    @Test
    void rob() {

        assertEquals(12, new Robber().rob(new int[]{2, 7, 9, 3, 1}));
        assertEquals(4, new Robber().rob(new int[]{1, 2, 3, 1}));

    }
}