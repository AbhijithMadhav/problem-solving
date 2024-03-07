package org.am.trie;


import java.util.HashMap;
import java.util.Map;

/*
 * Implement an API routing table
 *
 * Write method logic for two functions
 * withRoute(String path, String result) return void
 * route(String path) return result
 *
 * Match wildcard (*) in it. Use regex
 *
 * How can we use the code for concurrent requests/Environment?
 */
public class RoutingTable {

    public static final String STAR = "*";

    private static class TrieNode {
        String result;
        Map<String, TrieNode> children;
        public TrieNode() {
            result = null;
            children = new HashMap<>();
        }
    }

    private final TrieNode root = new TrieNode();

    public void withRoute(String path, String result) {
        String[] pathComponents = path.split("/");
        TrieNode cur = root;
        for (String pathComponent : pathComponents) {
            if (cur.children.containsKey(pathComponent)) {
                cur = cur.children.get(pathComponent);
            } else {
                TrieNode trieNode = new TrieNode();
                cur.children.put(pathComponent, trieNode);
                cur = trieNode;
            }
        }
        cur.result = result;
    }

    public String route(String path) {
        String[] pathComponents = path.split("/");
        TrieNode cur = root;
        for (String pathComponent : pathComponents) {
            if (cur.children.containsKey(pathComponent))
                cur = cur.children.get(pathComponent);
            else if (cur.children.containsKey(STAR))
                cur = cur.children.get(STAR);
            else
                return null;
        }
        return cur.result;
    }
}
