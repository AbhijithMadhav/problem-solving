package org.am.others;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarFleetTest {

    @Test
    void carFleet() {
        assertEquals(3, new CarFleet().carFleet(12, new int[]{10,8,0,5,3}, new int[]{2,4,1,1,3}));
    }
}