package org.am.binary.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInRotatedArrayTest {

    @Test
    void search() {
        assertEquals(0, new SearchInRotatedArray().search(new int[]{5, 1, 3}, 5));
        assertEquals(1, new SearchInRotatedArray().search(new int[]{5, 1, 3}, 1));
        assertEquals(2, new SearchInRotatedArray().search(new int[]{5, 1, 3}, 3));

        assertEquals(2, new SearchInRotatedArray().search(new int[]{1, 3, 5}, 5));
        assertEquals(-1, new SearchInRotatedArray().search(new int[]{1, 3, 5}, 4));

        assertEquals(1, new SearchInRotatedArray().search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 2));
        assertEquals(0, new SearchInRotatedArray().search(new int[]{2, 3, 4, 5, 6, 7, 8, 9, 1}, 2));
        assertEquals(8, new SearchInRotatedArray().search(new int[]{3, 4, 5, 6, 7, 8, 9, 1, 2}, 2));
        assertEquals(7, new SearchInRotatedArray().search(new int[]{4, 5, 6, 7, 8, 9, 1, 2, 3}, 2));
        assertEquals(6, new SearchInRotatedArray().search(new int[]{5, 6, 7, 8, 9, 1, 2, 3, 4}, 2));
        assertEquals(5, new SearchInRotatedArray().search(new int[]{6, 7, 8, 9, 1, 2, 3, 4, 5}, 2));
        assertEquals(4, new SearchInRotatedArray().search(new int[]{7, 8, 9, 1, 2, 3, 4, 5, 6}, 2));
        assertEquals(3, new SearchInRotatedArray().search(new int[]{8, 9, 1, 2, 3, 4, 5, 6, 7}, 2));
        assertEquals(2, new SearchInRotatedArray().search(new int[]{9, 1, 2, 3, 4, 5, 6, 7, 8}, 2));
        assertEquals(0, new SearchInRotatedArray().search(new int[]{2}, 2));
        assertEquals(0, new SearchInRotatedArray().search(new int[]{2, 1}, 2));
        assertEquals(1, new SearchInRotatedArray().search(new int[]{1, 2}, 2));
        assertEquals(1, new SearchInRotatedArray().search(new int[]{2, 1}, 1));
        assertEquals(0, new SearchInRotatedArray().search(new int[]{1, 2}, 1));

    }
}