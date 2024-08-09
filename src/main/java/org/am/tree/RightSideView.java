package org.am.tree;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-right-side-view/">...</a>
 */

public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return Collections.emptyList();

        Deque<List<TreeNode>> levelList = new LinkedList<>();
        levelList.add(List.of(root));

        List<Integer> result = new LinkedList<>();

        while (!levelList.isEmpty()) {
            List<TreeNode> curLevelNodes = levelList.remove();
            result.add(curLevelNodes.getLast().val);

            List<TreeNode> nextLevelNodes = new LinkedList<>();
            for (TreeNode curLevelNode : curLevelNodes) {
                if (curLevelNode.left != null)
                    nextLevelNodes.add(curLevelNode.left);
                if (curLevelNode.right != null)
                    nextLevelNodes.add(curLevelNode.right);
            }
            if (!nextLevelNodes.isEmpty())
                levelList.add(nextLevelNodes);
        }
        return result;
    }
}
