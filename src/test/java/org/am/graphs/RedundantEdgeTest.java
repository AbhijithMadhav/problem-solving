package org.am.graphs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RedundantEdgeTest {

    @Test
    void findRedundantConnection() {
        assertThat(new RedundantEdge().findRedundantConnection(
                new int[][]{{1,2}, {1, 3}, {2, 3}}
        )).contains(2, 3);

        assertThat(new RedundantEdge().findRedundantConnection(
                new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 1}, {1, 5}})
        ).contains(1, 4);
    }
}