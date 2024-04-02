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
        if (root.left != null) {
            if (root.left.val >= root.val)
                return false;
            if (!isValidBST(root.left))
                return false;
        }
        if (root.right != null) {
            if (root.right.val <= root.val)
                return false;
            return isValidBST(root.right);
        }
        return true;
    }
}
