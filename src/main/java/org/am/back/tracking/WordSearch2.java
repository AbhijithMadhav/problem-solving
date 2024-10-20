package org.am.back.tracking;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/word-search-ii/">...</a>
 * Constraints:
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] is a lowercase English letter.
 * 1 <= words.length <= 3 * 10^4
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * All the strings of words are unique.
 * <a href="https://www.youtube.com/watch?v=asbcE9mZz_U">...</a>
 * Complexity : O(mn*4^words[i].lenght)
 */
public class WordSearch2 {

    private static class Node {
        private final Map<Character, Node> children = new HashMap<>();
        private boolean eow = false;
    }

    Set<String> res = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        Node root = constructTrie(words);
        for (int m = 0; m < board.length; m++) {
            for (int n = 0; n < board[m].length; n++) {
                boolean[][] visited = initializeVisited(board.length, board[m].length);
                dfs(board, m, n, root, "", visited);
            }
        }
        return res.stream().toList();
    }

    private void dfs(char[][] board, int m, int n, Node node, String path, boolean[][] visited) {
        if (m < 0 || m == board.length || n < 0 || n == board[m].length
                || visited[m][n]
                || !node.children.containsKey(board[m][n]))
            return;

        visited[m][n] = true;
        if (node.children.get(board[m][n]).eow)
            res.add(path + board[m][n]);

        for (int[] xy : new int[][]{{m + 1, n}, {m - 1, n}, {m, n + 1}, {m, n - 1}}) {
            int x = xy[0];
            int y = xy[1];
            if (x >= 0 && x < board.length && y >= 0 && y < board[m].length) {
                dfs(board, x, y,
                        node.children.get(board[m][n]),
                        path + board[m][n], visited
                );
            }
        }
        visited[m][n] = false;
    }

    private Node constructTrie(String[] words) {
        Node root = new Node();
        Arrays.stream(words).forEach(word -> insert(root, word));
        return root;
    }

    private void insert(Node root, String word) {
        for (Character c : word.toCharArray()) {
            if (!root.children.containsKey(c))
                root.children.put(c, new Node());
            root = root.children.get(c);
        }
        root.eow = true;
    }

    private boolean[][] initializeVisited(int m, int n) {
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            visited[i] = new boolean[n];
            Arrays.fill(visited[i], false);
        }
        return visited;
    }
}

