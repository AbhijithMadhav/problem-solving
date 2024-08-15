package org.am.tree;

import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/description/">...</a>
 */
public class MaxPathSum {

    private int maxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathSumThroughNode(root);
        return maxPathSum;
    }

    // max path sum passing through `node` which can be used by the parent of `node`
    private int maxPathSumThroughNode(TreeNode node) {
        if (node == null)
            return Integer.MIN_VALUE;
        int maxThroughRightNode = maxPathSumThroughNode(node.right);
        int maxThroughLeftNode = maxPathSumThroughNode(node.left);
        maxPathSum = IntStream.of(
                maxPathSum,
                node.val,
                node.val + normalizeForAddition(maxThroughRightNode),
                node.val + normalizeForAddition(maxThroughLeftNode),
                node.val + normalizeForAddition(maxThroughRightNode) + normalizeForAddition(maxThroughLeftNode)
        ).max().getAsInt();
        return IntStream.of(node.val,
                node.val + normalizeForAddition(maxThroughRightNode),
                node.val + normalizeForAddition(maxThroughLeftNode)
        ).max().getAsInt();
    }

    private int normalizeForAddition(int val) {
        return val == Integer.MIN_VALUE ? 0 : val;
    }
}
