package org.am.back.tracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CombinationSumTest {

    @Test
    void combinationSumOld() {
        //System.out.println(new CombinationSum().combinationSum(new int[]{1,1,7}, 8));

        assertThat(new CombinationSum().combinationSum(new int[] {2, 3, 6, 7}, 7)).hasSameElementsAs(List.of(List.of(2, 2, 3), List.of(7)));
        assertThat(List.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5))).hasSameElementsAs(new CombinationSum().combinationSum(new int[] {2, 3, 5}, 8));
        assertThat(List.of(List.of(2, 2, 2, 2, 2), List.of(2, 2, 3, 3), List.of(2, 3, 5), List.of(5, 5))).hasSameElementsAs(new CombinationSum().combinationSum(new int[] {2, 3, 5}, 10));

    }
}