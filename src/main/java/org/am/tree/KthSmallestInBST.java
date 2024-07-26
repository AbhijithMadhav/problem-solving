package org.am.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/">...</a>
 */
public class KthSmallestInBST {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> sortedList = new ArrayList<>();
        inOrderTraverse(root, sortedList);
        assert sortedList.size() >= k - 1;
        return sortedList.get(k - 1);
    }

    private void inOrderTraverse(TreeNode node, List<Integer> sortedList) {
        if (node == null)
            return;
        inOrderTraverse(node.left, sortedList);
        sortedList.addLast(node.val);
        inOrderTraverse(node.right, sortedList);
    }
}
