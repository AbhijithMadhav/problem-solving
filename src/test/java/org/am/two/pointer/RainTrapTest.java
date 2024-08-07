package org.am.two.pointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RainTrapTest {

    @Test
    void trap() {

        assertEquals(9, new RainTrap().trap(new int[] {4,2,0,3,2,5}));
        assertEquals(6, new RainTrap().trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}