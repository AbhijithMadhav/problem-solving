package org.am.back.tracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PermutationsTest {

    @Test
    void permute() {
        assertThat(new Permutations().permute(new int[]{1})).hasSameElementsAs(List.of(List.of(1)));
        assertThat(new Permutations().permute(new int[]{1, 2})).hasSameElementsAs(List.of(List.of(1, 2), List.of(2, 1)));
        assertThat(new Permutations().permute(new int[]{1, 2, 3})).hasSameElementsAs(List.of(
                List.of(1, 2, 3), List.of(1, 3, 2),
                List.of(2, 1, 3), List.of(2, 3, 1),
                List.of(3, 1, 2), List.of(3, 2, 1)
        ));
    }
}