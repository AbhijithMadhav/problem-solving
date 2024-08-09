package org.am.tree;

/**
 * <a href="https://leetcode.com/problems/subtree-of-another-tree/submissions/1350252504/">...</a>
 */
public class Subtree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;
        if (root == null || subRoot == null)
            return false;
        if ((root.val == subRoot.val) && isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right))
                return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
