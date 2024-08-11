package org.am.graphs.union_find;

/**
 * <a href="https://leetcode.com/problems/graph-valid-tree/description/">...</a>
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 */
public class ValidTree {

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;

        int[] id = new int[n];
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = 0;
            id[i] = i;
        }

        for (int[] edge : edges) {
            int v = edge[0];
            int w = edge[1];
            // If the vertices already belong to the same component, then we have a cycle
            if (find(v, id) == find(w, id))
                return false;
            quickUnion(v, w, id, height);
        }
        return true;
    }

    int find(int v, int[] id) {
        while(id[v] != v)
            v = id[v];
        return v;

    }

    void quickUnion(int v, int w, int[] id, int[] height) {
        int wRoot = find(w, id);
        int vRoot = find(v, id);
        if (height[wRoot] < height[vRoot]) {
            id[wRoot] = vRoot;
            height[wRoot] = height[vRoot] + 1;
        } else {
            id[vRoot] = wRoot;
            height[vRoot] = height[wRoot] + 1;
        }
    }
}
