package org.am.tree;


/**
 * Given the root of a binary tree, invert the tree, and return its root.
 */
public class Invert {

    // Note : inverting tree after recursi
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
