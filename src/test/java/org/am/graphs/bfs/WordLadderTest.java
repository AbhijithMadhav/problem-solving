package org.am.graphs.bfs;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordLadderTest {

    @Test
    void ladderLength() {
        assertEquals(1, new WordLadder().ladderLength("AACCGGTT", "AACCGGTA", List.of("AACCGGTA")));
        assertEquals(4, new WordLadder().ladderLength("hit", "cog", List.of("hit", "hot", "dot", "lot", "log", "dog", "cog")));
    }
}