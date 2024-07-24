package org.am.graphs.union_find;

/**
 * <a href="https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/">...</a>
 * You have a graph of n nodes. You are given an integer n and an array of edges. Return the number of
 * connected components
 */
public class ConnectedComponents {

    public int connectedComponentsQF(int n, int[][] edges) {
        int[] id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
        int count = n;


        for (int[] edge : edges) {
            int v = edge[0];
            int w = edge[1];
            int vComponent = findQF(v, id);
            int wComponent = findQF(w, id);
            if (vComponent == wComponent)
                continue;
            for (int i = 0; i < n; i++)
                if (id[i] == vComponent)
                    id[i] = wComponent;
            count--;
        }
        return count;
    }

    private int findQF(int v, int[] component) {
        return component[v];
    }

    public int connectedComponentsQU(int n, int[][] edges) {
        int[] id = new int[n];
        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            height[i] = 1;
        }
        int count = n;


        for (int[] edge : edges) {
            int p = edge[0];
            int q = edge[1];
            int pRoot = findQU(p, id);
            int qRoot = findQU(q, id);
            if (pRoot == qRoot)
                continue;
            if (height[qRoot] < height[pRoot]) {
                id[q] = pRoot;
                height[p] = height[q] + 1;
            } else {
                id[p] = qRoot;
                height[q] = height[p] + 1;
            }
            count--;
        }
        return count;
    }

    private int findQU(int v, int[] component) {
        while(v != component[v]) {
            component[v] = component[component[v]];
            v = component[v];
        }
        return v;
    }
}
