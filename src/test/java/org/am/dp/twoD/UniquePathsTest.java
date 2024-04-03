package org.am.dp.twoD;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniquePathsTest {

    @Test
    void uniquePaths() {
        assertEquals(28, new UniquePaths().uniquePaths(3, 7));
        assertEquals(3, new UniquePaths().uniquePaths(3, 2));
    }
}