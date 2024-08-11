package org.am.graphs.bfs;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/clone-graph/description/">...</a>
 */
public class GraphClone {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Map<Integer, Node> nodeMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Set<Node> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            Node v = queue.remove();
            visited.add(v);
            nodeMap.putIfAbsent(v.val, new Node(v.val));
            v.neighbors.stream()
                    .filter(w -> !visited.contains(w))
                    .forEach(w -> {
                        queue.add(w); // for traversal
                        nodeMap.putIfAbsent(w.val, new Node(w.val)); // cloned adj list
                        nodeMap.get(v.val).neighbors.add(nodeMap.get(w.val)); // cloned neighbors
                        nodeMap.get(w.val).neighbors.add(nodeMap.get(v.val)); // cloned edge back
                    });
        }
        return nodeMap.get(node.val);
    }
}
