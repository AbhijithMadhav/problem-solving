package org.am.dp.twoD;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPathMatrixTest {

    @Test
    void longestIncreasingPath() {
        assertEquals(4, new LongestPathMatrix().longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));
        assertEquals(4, new LongestPathMatrix().longestIncreasingPath(new int[][]{{3,4,5},{3,2,6},{2,2,1}}));
    }
}