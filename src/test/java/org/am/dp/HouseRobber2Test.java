package org.am.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseRobber2Test {

    @Test
    void rob() {

        assertEquals(3, new HouseRobber2().rob(new int[]{1, 2, 3}));
    }
}