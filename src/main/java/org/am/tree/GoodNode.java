package org.am.tree;

/**
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 * Return the number of good nodes in the binary tree.
 */
public class GoodNode {

    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }

    // Remember the max seen in the path from the root to the node
    // Recursion remembers this
    public int goodNodes(TreeNode root, int maxTillNow) {
        int count = 0;
        if (root == null)
            return count;

        if (maxTillNow <= root.val) {
            count = 1;
        }

        maxTillNow = Math.max(maxTillNow, root.val);
        count += goodNodes(root.left, maxTillNow);
        count += goodNodes(root.right, maxTillNow);

        return count;
    }
}
