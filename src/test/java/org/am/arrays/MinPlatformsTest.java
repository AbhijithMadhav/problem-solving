package org.am.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinPlatformsTest {

    @Test
    void minPlatforms() {
        assertEquals(3,
                new MinPlatforms().minPlatforms(new int[]{900, 940, 950, 1100, 1500, 1800}, new int[]{910, 1200, 1120, 1130, 1900, 2000}));
    }
}