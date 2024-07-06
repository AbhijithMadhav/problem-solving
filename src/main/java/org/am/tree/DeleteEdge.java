package org.am.tree;

/**
 * Given the root of a binary tree, split the binary tree into two subtrees by removing one edge such that the product of the sums of the subtrees is maximized.
 * Return the maximum product of the sums of the two subtrees. Since the answer may be too large, return it modulo 109 + 7.
 * Note that you need to maximize the answer before taking the mod and not after taking it.
 */
public class DeleteEdge {

    private long maxProduct;

    public int maxProduct(TreeNode root) {
        maxProduct = 0;
        traverse(root, sum(root));
        return (int) (maxProduct % (1000000000 + 7));
    }

    private long traverse(TreeNode root, long totalSum) {
        if (root == null)
            return 0;
        long sum = traverse(root.left, totalSum) + traverse(root.right, totalSum) + root.val;
        long product = sum * (totalSum - sum);
        maxProduct = Math.max(maxProduct, product);
        return sum;
    }

    private static long sum(TreeNode root) {
        if (root == null)
            return 0;
        return root.val + sum(root.right) + sum(root.left);
    }
}
