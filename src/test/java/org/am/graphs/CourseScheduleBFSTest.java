package org.am.graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseScheduleBFSTest {

    @Test
    void canFinish() {
        assertTrue(new CourseScheduleBFS().canFinish(2, new int[][]{{1, 0}}));
        //assertArrayEquals(new int[]{0, 1}, new CourseSchedule().findOrder(2, new int[][]{{1, 0}}));

        assertFalse(new CourseScheduleBFS().canFinish(2, new int[][]{{0, 1}, {1, 0}}));
        //assertArrayEquals(new int[]{}, new CourseSchedule().findOrder(2, new int[][]{{0, 1}, {1, 0}}));

        assertTrue(new CourseScheduleBFS().canFinish(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
        assertTrue(new CourseScheduleBFS().canFinish(3, new int[][]{{0, 1}, {1, 2}}));
        assertTrue(new CourseScheduleBFS().canFinish(5, new int[][]{{0, 1}, {1, 2}, {3, 4}}));
    }
}