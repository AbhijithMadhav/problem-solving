package org.am.graphs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CourseScheduleTest {

    @Test
    void canFinish() {
        assertTrue(new CourseSchedule().canFinish(2, new int[][]{{1, 0}}));
        assertArrayEquals(new int[]{0, 1}, new CourseSchedule().findOrder(2, new int[][]{{1, 0}}));

        assertFalse(new CourseSchedule().canFinish(2, new int[][]{{0, 1}, {1, 0}}));
        assertArrayEquals(new int[]{}, new CourseSchedule().findOrder(2, new int[][]{{0, 1}, {1, 0}}));

        assertTrue(new CourseSchedule().canFinish(4, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
        assertTrue(new CourseSchedule().canFinish(2, new int[][]{{0, 1}, {1, 2}}));
        assertTrue(new CourseSchedule().canFinish(2, new int[][]{{0, 1}, {1, 2}, {3, 4}}));
    }
}