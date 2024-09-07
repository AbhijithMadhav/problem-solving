package org.am.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StairsTest {

    @Test
    void climbStairs() {
        new Stairs().climbStairs(10);
        assertEquals(0, new Stairs().climbStairs(0));
        assertEquals(1, new Stairs().climbStairs(1));
        assertEquals(2, new Stairs().climbStairs(2));
        assertEquals(3, new Stairs().climbStairs(3));


    }
}