package org.am.hash;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GroupAnagramsTest {

    @Test
    void groupAnagrams() {

        assertThat(
                List.of(
                        List.of("bat"),
                        List.of("nat","tan"),
                        List.of("ate","eat","tea")
                )).hasSameElementsAs(
                new GroupAnagrams().groupAnagrams(
                        new String[]{"eat","tea","tan","ate","nat","bat"}
                ));
    }
}