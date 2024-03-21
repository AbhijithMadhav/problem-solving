package org.am.two.pointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    @Test
    void name() {
        assertEquals(49, new Container().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}