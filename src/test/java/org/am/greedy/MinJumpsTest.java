package org.am.greedy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinJumpsTest {

    private MinJumps minJumps;
    @BeforeEach
    void setUp() {
        minJumps = new MinJumps();
    }

    @Test
    void jump() {
        assertEquals(2, minJumps.jump(new int[]{2,3,1,1,4}));
        assertEquals(2, minJumps.jump(new int[]{2,3,0,1,4}));
        assertEquals(1, minJumps.jump(new int[]{1, 2}));
        assertEquals(2, minJumps.jump(new int[]{4,1,1,3,1,1,1}));
        assertEquals(3, minJumps.jump(new int[]{1, 1, 1, 1}));

    }
}