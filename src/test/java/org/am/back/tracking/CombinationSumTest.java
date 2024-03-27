package org.am.back.tracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CombinationSumTest {

    @Test
    void combinationSum() {

        assertEquals(List.of(List.of(2, 2, 3), List.of(7)), new CombinationSum().combinationSum(new int[] {2, 3, 6, 7}, 7));
        assertEquals(List.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5)), new CombinationSum().combinationSum(new int[] {2, 3, 5}, 8));
        assertEquals(List.of(List.of(2, 2, 2, 2, 2), List.of(2, 2, 3, 3), List.of(2, 3, 5), List.of(5, 5)), new CombinationSum().combinationSum(new int[] {2, 3, 5}, 10));


    }
}