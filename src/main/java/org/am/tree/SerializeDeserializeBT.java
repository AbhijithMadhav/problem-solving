package org.am.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class SerializeDeserializeBT {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder codec = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<TreeNode> nextLevelNodes = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                codec.append(node == null ? "null," : node.val + ",");
                if (node != null) {
                    nextLevelNodes.add(node.left);
                    nextLevelNodes.add(node.right);
                }
            }
            queue.addAll(nextLevelNodes);
        }
        return codec.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodeVals = data.split(",");
        TreeNode root = getTreeNode(nodeVals[0]);
        int i = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty() && i < nodeVals.length) {
            TreeNode node = queue.remove();
            if (node == null)
                continue;
            String leftNodeVal = nodeVals[i++];
            node.left = getTreeNode(leftNodeVal);
            String rightNodeVal = nodeVals[i++];
            node.right = getTreeNode(rightNodeVal);
            queue.add(node.left);
            queue.add(node.right);
        }
        return root;
    }

    private static TreeNode getTreeNode(String nodeVal) {
        return Objects.equals(nodeVal, "null")
                ? null : new TreeNode(Integer.parseInt(nodeVal), null, null);
    }
}
