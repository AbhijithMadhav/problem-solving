package org.am.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlidingWindowMaxTest {

    @Test
    void maxSlidingWindow() {
        assertArrayEquals(
                new int[]{3,3,5,5,6,7},
                new SlidingWindowMax().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)
        );
    }
}