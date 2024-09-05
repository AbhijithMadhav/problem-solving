package org.am.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskSchedulerTest {

    @Test
    void leastInterval() {
        assertEquals(8, new TaskScheduler().leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
        assertEquals(6, new TaskScheduler().leastInterval(new char[]{'A','A','A','B','B','B'}, 1));
        assertEquals(6, new TaskScheduler().leastInterval(new char[]{'A','C','A','B','D','B'}, 1));
        assertEquals(10, new TaskScheduler().leastInterval(new char[]{'A','A','A', 'B','B','B'}, 3));
    }
}