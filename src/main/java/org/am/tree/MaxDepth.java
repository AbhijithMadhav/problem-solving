package org.am.tree;


public class MaxDepth {

    // The Crux is to count from the leaf to the root
    // The opposite is more complicated
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
