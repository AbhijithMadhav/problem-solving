package org.am.back.tracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PalindromePartitioningTest {

    @Test
    void partition() {
        assertThat(new PalindromePartitioning().partition("aab")).hasSameElementsAs(
                List.of(
                        List.of("a", "a", "b"),
                        List.of("aa", "b"))
        );
        assertThat(new PalindromePartitioning().partition("a")).hasSameElementsAs(List.of(List.of("a")));
        new PalindromePartitioning().partition("aaaaaaaaaaaaaaaa");
    }
}