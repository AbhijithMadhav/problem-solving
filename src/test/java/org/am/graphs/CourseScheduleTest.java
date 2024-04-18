package org.am.graphs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseScheduleTest {

    @Test
    void canFinish() {
        assertArrayEquals(new int[] {5, 0, 4, 3, 2, 7, 6, 1}, new CourseSchedule().findOrder(8, new int[][]{{1, 2}, {1, 6}, {2, 4}, {2, 3}, {3, 4}, {6, 7}, {7, 3}}));
        assertTrue(new CourseSchedule().canFinish(2, new int[][]{{1, 0}}));
        assertArrayEquals(new int[]{0, 1}, new CourseSchedule().findOrder(2, new int[][]{{1, 0}}));

        assertFalse(new CourseSchedule().canFinish(2, new int[][]{{0, 1}, {1, 0}}));
        assertArrayEquals(new int[]{}, new CourseSchedule().findOrder(2, new int[][]{{0, 1}, {1, 0}}));

        assertTrue(new CourseSchedule().canFinish(4, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
        assertTrue(new CourseSchedule().canFinish(2, new int[][]{{0, 1}, {1, 2}}));
        assertTrue(new CourseSchedule().canFinish(2, new int[][]{{0, 1}, {1, 2}, {3, 4}}));
    }
}