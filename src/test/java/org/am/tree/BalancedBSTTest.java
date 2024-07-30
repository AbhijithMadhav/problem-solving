package org.am.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalancedBSTTest {

    @Test
    void isBalanced() {
        assertFalse(new BalancedBST().isBalanced(new TreeNode(
                1,
                new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(4, null, null),
                                new TreeNode(4, null, null)
                        ),
                        new TreeNode(3, null, null)
                ),
                new TreeNode(2, null, null))));

        assertTrue(new BalancedBST().isBalanced(new TreeNode(
                3,
                new TreeNode(9, null, null),
                new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)))));

        assertTrue(new BalancedBST().isBalanced(new TreeNode(1, null, null)));
        assertTrue(new BalancedBST().isBalanced(null));
    }
}