package org.am.back.tracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SubSetTest {

    @Test
    void subsets() {

        assertThat(new SubSet().subsets(new int[] {1, 2, 3})).hasSameElementsAs(
                List.of(
                        List.of(),
                        List.of(1), List.of(2), List.of(3),
                        List.of(1, 2), List.of(1, 3), List.of(2, 3),
                        List.of(1, 2, 3)
                )
        );
    }
}