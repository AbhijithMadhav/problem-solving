package org.am.two.pointer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ThreeSumTest {

    @Test
    void threeSum() {
        assertThat(new ThreeSum().threeSum(new int[]{-1,0,1,2,-1,-4})).hasSameElementsAs(List.of(List.of(-1, -1, 2), List.of(-1, 0, 1)));
    }
}