package org.others;

import java.util.*;

public class Trie {

    static class Node {
        Map<Character, Node> children = new HashMap<>();
        boolean endOfWord = false;
    }
    private final Node root;
    public Trie() {
        root = new Node();
    }
    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children.containsKey(c))
                cur = cur.children.get(c);
            else {
                Node node = new Node();
                cur.children.put(c, node);
                cur = node;
            }
        }
        cur.endOfWord = true;
    }

    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children.containsKey(c)) {
                cur = cur.children.get(c);
            } else
                return false;
        }
        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.children.containsKey(c)) {
                cur = cur.children.get(c);
            } else
                return false;
        }
        return true;
    }

    public List<String> collect() {
        return collect(root);
    }

    public List<String> collect(String prefix) {
        if (startsWith(prefix))
            return collect(root);
        return Collections.emptyList();
    }

    private List<String> collect(Node root) {
        if(root.children.isEmpty())
            return Collections.singletonList("");
        List<String> results = new LinkedList<>();
        for (Character prefix : root.children.keySet()) {
            Node childTrie = root.children.get(prefix);
            results.addAll(
                    collect(childTrie)
                            .stream()
                            .map(result -> prefix + result)
                            .toList()
            );
        }
        return results;
    }
}


