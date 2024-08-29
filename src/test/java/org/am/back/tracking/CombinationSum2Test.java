package org.am.back.tracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CombinationSum2Test {

    @Test
    void combinationSum2Old2() {
        assertThat(new CombinationSum2().combinationSum2(new int[]{1,1,6,7}, 8))
                .hasSameElementsAs(List.of(List.of(1, 1, 6), List.of(1, 7)));
    }
}