package org.am.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the
 * level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */
public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> loList = new LinkedList<>();

        if (root == null)
            return loList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<TreeNode> list = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                list.add(node);
            }
            for (TreeNode node : list) {
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            loList.add(list.stream().map(n -> n.val).toList());
        }
        return loList;
    }
}
