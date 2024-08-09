package org.am.tree;

public class DiameterOfBinaryTree {

    // w.r.t to a node the longest path which passes through it is the depth of its left subtree plus the depth
    // of its right subtree
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int diameterOfLeft = diameterOfBinaryTree(root.left);
        int diameterOfRight = diameterOfBinaryTree(root.right);
        int diameter = (root.left == null ? 0 : depth(root.left) )
                + (root.right == null ? 0 : depth(root.right) + 1);
        return Math.max(diameter, Math.max(diameterOfLeft, diameterOfRight));
    }

    private int depth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
