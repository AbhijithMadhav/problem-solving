package org.am.tree;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * The left
 * subtree
 *  of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class ValidBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long minConstraint, long maxConstraint) {
        if (node == null)
            return true;
        if (node.val > minConstraint && node.val < maxConstraint)
            return isValidBST(node.left, minConstraint, node.val) && isValidBST(node.right, node.val, maxConstraint);
        return false;
    }
}
