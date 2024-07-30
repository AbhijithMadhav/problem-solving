package org.am.tree;

public class BalancedBST {

    private record Result(boolean isBalanced, int height){}

    public boolean isBalanced(TreeNode root) {
        return preOrderTraverse(root).isBalanced;
    }

    private Result preOrderTraverse(TreeNode node) {
        if (node == null) {
            return new Result(true, 0);
        } else {
            Result leftResult = preOrderTraverse(node.left);
            Result rightResult = preOrderTraverse(node.right);
            return new Result(
                    leftResult.isBalanced && rightResult.isBalanced
                            && Math.abs(leftResult.height - rightResult.height) <= 1,
                    Math.max(leftResult.height, rightResult.height) + 1
            );
        }
    }
}
