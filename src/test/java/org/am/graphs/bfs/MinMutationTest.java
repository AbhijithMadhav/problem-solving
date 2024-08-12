package org.am.graphs.bfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMutationTest {

    @Test
    void minMutation() {
        assertEquals(1, new MinMutation().minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
        assertEquals(4, new MinMutation().minMutation("hit", "cog", new String[]{"hit", "hot", "dot", "lot", "log", "dog", "cog"}));

    }
}