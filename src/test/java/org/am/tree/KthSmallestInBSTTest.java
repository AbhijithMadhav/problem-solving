package org.am.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthSmallestInBSTTest {

    @Test
    void kthSmallest() {
        assertEquals(1, new KthSmallestInBST().kthSmallest(
                new TreeNode(
                        3,
                        new TreeNode(1, null,
                                new TreeNode(2, null, null)
                        ),
                        new TreeNode(4, null, null)
                ), 1));
    }
}