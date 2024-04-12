package org.am.greedy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LetterCombinationsOfPhoneNumberTest {

    @Test
    void letterCombinations() {

        assertThat(new LetterCombinationsOfPhoneNumber().letterCombinations("2"))
                .hasSameElementsAs(List.of("a", "b", "c"));
        assertThat(new LetterCombinationsOfPhoneNumber().letterCombinations("23"))
                .hasSameElementsAs(List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
    }
}