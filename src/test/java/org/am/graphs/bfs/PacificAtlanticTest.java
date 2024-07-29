package org.am.graphs.bfs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PacificAtlanticTest {

    @Test
    void pacificAtlantic() {

        assertThat(new PacificAtlantic().pacificAtlantic(new int[][]{
                {2, 1},
                {1, 2}})
        ).hasSameElementsAs(List.of(List.of(0, 0), List.of(0, 1), List.of(1, 0), List.of(1, 1)));

        assertThat(new PacificAtlantic().pacificAtlantic(new int[][]{
                        {4, 2, 7, 3, 4},
                        {7, 4, 6, 4, 7},
                        {6, 3, 5, 3, 6}
                }
        )).hasSameElementsAs(List.of(
                List.of(0, 2), List.of(0, 4), List.of(1, 0), List.of(1, 1), List.of(1, 2),
                List.of(1,3), List.of(1, 4), List.of(2, 0)
        ));
    }
}