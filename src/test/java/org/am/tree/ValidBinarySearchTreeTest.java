package org.am.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidBinarySearchTreeTest {

    @Test
    void isValidBST() {
        TreeNode root = new TreeNode(
                5,
                new TreeNode(4, null, null),
                new TreeNode(
                        6,
                        new TreeNode(3, null, null),
                        new TreeNode(7, null, null)
                )
        );

        assertFalse(new ValidBinarySearchTree().isValidBST(root));
        assertTrue(new ValidBinarySearchTree().isValidBST(new TreeNode(2147483647, null, null)));
    }
}