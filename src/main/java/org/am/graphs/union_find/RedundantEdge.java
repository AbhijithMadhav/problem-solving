package org.am.graphs.union_find;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/redundant-connection/description/">...</a>
 */
// The crux is in recognizing that in order to return the last inputted edge of a cycle we would need an algo
// which would scan the edges in a given order
// With DFS the scanning follows the transitive nature of connectedness of edges and won't serve the purpose
// With Union-Find we can scan the edges in the input order and detect a cycle if a find operation shows that
// the vertices of an edge already belong to a single component

public class RedundantEdge {

    private int[] id;
    // height of the smallest subcomponent
    private int[] height;

    public int[] findRedundantConnection(int[][] edges) {
        id = new int[edges.length + 1];
        for (int i = 0; i < edges.length + 1; i++) {
            id[i] = i;
        }
        height = new int[edges.length + 1];
        Arrays.fill(height, 1);

        for (int[] edge : edges) {
            int v = edge[0];
            int w = edge[1];
            // If the vertices already belong to the same component then we have a cycle
            if (find(v) == find(w))
                return edge;
            quickUnion(v, w);
        }
        return null;
    }

    private void quickUnion(int p, int q) {
        int qRoot = find(q);
        int pRoot = find(p);

        if (height[pRoot] < height[qRoot]) {
            id[pRoot] = qRoot;
            height[qRoot] = height[pRoot] + 1; // TODO : Need to get an intution about this
        }
        else {
            id[qRoot] = pRoot;
            height[pRoot] = height[qRoot] + 1;
        }
    }

    private int find(int p) {
        while(id[p] != p)
            p = id[p];
        return p;
    }
}
