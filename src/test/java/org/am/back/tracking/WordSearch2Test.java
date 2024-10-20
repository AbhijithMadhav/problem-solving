package org.am.back.tracking;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WordSearch2Test {

    @Test
    void findWords() {

        assertThat(new WordSearch2().findWords(
                new char[][] {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},
                new String[]{"oath", "oathfi"}
                )).hasSameElementsAs(List.of("oath", "oathfi"));
        assertThat(new WordSearch2().findWords(
                new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},
                new String[]{"hklf", "hf"}
        )).hasSameElementsAs(List.of("hklf", "hf"));

        assertThat(new WordSearch2().findWords(
                new char[][]{{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}},
                new String[]{"oa","oaa"})
        ).hasSameElementsAs(List.of("oa","oaa"));

        assertThat(new WordSearch2().findWords(
                new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},
                new String[]{"oath","pea","eat","rain"})
        ).hasSameElementsAs(List.of("eat", "oath"));



    }
}