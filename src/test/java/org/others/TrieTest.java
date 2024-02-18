package org.others;

import org.am.others.Trie;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {

    @Test
    public void test() {
        Trie trie = new Trie();
        trie.insert("apple");
        assertTrue(trie.search("apple"));
        assertFalse(trie.search("appa"));
        assertFalse(trie.search("b"));
        assertFalse(trie.search("app"));
        assertTrue(trie.startsWith("a"));
        assertTrue(trie.startsWith("app"));
        assertTrue(trie.startsWith("appl"));
        assertTrue(trie.startsWith("apple"));
        assertFalse(trie.startsWith("apd"));
        trie.insert("app");
        assertTrue(trie.search("app"));
    }

    @Test
    public void testCollect() {
        Trie trie = new Trie();
        trie.insert("apple");
        org.assertj.core.api.Assertions.assertThat(trie.collect("asd")).isEmpty();
        org.assertj.core.api.Assertions.assertThat(trie.collect("a")).containsExactlyInAnyOrder("apple");
        org.assertj.core.api.Assertions.assertThat(trie.collect("app")).containsExactlyInAnyOrder("apple");
        trie.insert("application");
        org.assertj.core.api.Assertions.assertThat(trie.collect("a")).containsExactlyInAnyOrder("apple", "application");
        trie.insert("applicants");
        org.assertj.core.api.Assertions.assertThat(trie.collect()).containsExactlyInAnyOrder("apple", "application", "applicants");

    }

    @Test
    public void anotherTest() {
        Trie trie = new Trie();
        trie.insert("apple");
        assertTrue(trie.search("apple"));   // return True
        assertFalse(trie.search("app"));     // return False
        assertTrue(trie.startsWith("app")); // return True
        trie.insert("app");
        assertTrue(trie.search("app"));     // return True

    }

}