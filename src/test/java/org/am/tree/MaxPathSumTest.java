package org.am.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxPathSumTest {

    @Test
    void maxPathSum() {

        assertEquals(42,
                new MaxPathSum().maxPathSum(
                        new TreeNode(-10,
                                new TreeNode(9, null, null),
                                new TreeNode(20,
                                        new TreeNode(15, null, null),
                                        new TreeNode(7, null, null)
                                )
                        )
                )
        );
        assertEquals(3,
                new MaxPathSum().maxPathSum(
                    new TreeNode(
                            1,
                            new TreeNode(
                                    -2,
                                    new TreeNode(
                                            1,
                                            new TreeNode(-1, null, null),
                                            null
                                    ),
                                    new TreeNode(3, null, null)
                            ),
                            new TreeNode(
                                    -3,
                                    new TreeNode(-2, null, null),
                                    null
                            )
                    )
                )
        );
        assertEquals(-3, new MaxPathSum().maxPathSum(new TreeNode(-3, null, null)));
    }
}