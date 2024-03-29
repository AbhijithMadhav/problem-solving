package org.am.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DailyTemperatureTest {

    @Test
    void dailyTemperatures() {
        assertArrayEquals(new int[]{8,1,5,4,3,2,1,1,0,0}, new DailyTemperature().dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70}));
        assertArrayEquals(new int[]{1, 1, 4, 2, 1, 1, 0, 0}, new DailyTemperature().dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
        assertArrayEquals(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, new DailyTemperature().dailyTemperatures(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 10}));

    }
}