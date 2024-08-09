package org.am.tree;

/**
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/">...</a>
 */
public class LCA {

    // LCA is the node where p and q have to split on the back of the fact that the tree is a BST
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val <= root.val && q.val >= root.val || q.val <= root.val && p.val >= root.val)
                break;
            if (p.val < root.val)
                root = root.left;
            else
                root = root.right;
        }
        return root;
    }
}
