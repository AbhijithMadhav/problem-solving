package org.am.interval;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SetIntersectionSizeTest {

    @Test
    void intersectionSizeTwo() {
        //assertEquals(5, new SetIntersectionSize().intersectionSizeTwo(new int[][]{{1, 3}, {3, 7}, {8, 9}}));
        assertEquals(6, new SetIntersectionSize().intersectionSizeTwo(new int[][]{{1, 2}, {1, 3}, {3, 7}, {8, 9}}));
        assertEquals(5, new SetIntersectionSize().intersectionSizeTwo(new int[][]{{1, 3}, {3, 7}, {5, 7}, {7, 8}}));

    }
}