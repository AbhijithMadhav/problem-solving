package org.am.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevelOrderTraversalTest {

    @Test
    void levelOrder() {
        TreeNode root = new TreeNode(
                3,
                new TreeNode(9, null, null),
                new TreeNode(
                        20,
                        new TreeNode(15, null, null),
                        new TreeNode(7, null, null)
                        )
                );
    }
}