package org.am.graphs.bfs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/word-ladder/description/">...</a>
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.add(beginWord);
        Map<String, Set<String>> adjList = constructAdjList(wordSet);

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int ladderLength = 1;
        while(!queue.isEmpty()) { // O(n), n is the number of wordSet in the wordList
            List<String> words = queue.stream().toList();
            queue.clear();
            visited.addAll(words);
            Set<String> neighbors = getNeighbors(words, adjList).stream() // O(nm)
                    .filter(g -> !visited.contains(g))
                    .collect(Collectors.toSet());
            if (!neighbors.isEmpty())
                ladderLength++;
            if (neighbors.contains(endWord))
                return ladderLength;
            queue.addAll(neighbors);
        }
        return 0;
    }

    // O(nm)
    private static Set<String> getNeighbors(List<String> words, Map<String, Set<String>> adjList) {
        return words // n
                .stream()
                .map(WordLadder::oneCharMaskedPatterns)
                .flatMap(Collection::stream) // m
                .map(adjList::get)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    private static Set<String> oneCharMaskedPatterns(String word) {
        return IntStream.range(0, word.length()) // O(m) - m is the length of the word which is 8 in this case
                .mapToObj(i ->
                        word.substring(0, i)
                                + '*'
                                + (i + 1 < word.length() ? word.substring(i + 1) : "")
                )
                .collect(Collectors.toSet());
    }

    // Key is 1-char masked pattern of all words in the bank.
    // Value is all words that match the pattern.
    // This represents a graph whose nodes are labeled with the 1-char pattern
    // The adjacency list contains all words that match the pattern
    private static Map<String, Set<String>> constructAdjList(Set<String> words) {
        Map<String, Set<String>> adjList = new HashMap<>();
        for (String word : words) { // n
            oneCharMaskedPatterns(word).forEach(pattern -> { // m
                adjList.putIfAbsent(pattern, new HashSet<>());
                adjList.get(pattern).add(word);
            });
        }
        return adjList;
    }
}
