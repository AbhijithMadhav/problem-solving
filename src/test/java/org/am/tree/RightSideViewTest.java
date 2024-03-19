package org.am.tree;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RightSideViewTest {

    @Test
    void rightSideView() {
        TreeNode root = new TreeNode(0, null,
                new TreeNode(1, null,
                        new TreeNode(2, null,
                                new TreeNode(3, null, null)
                        )
                )
        );

        assertEquals(List.of(0, 1, 2, 3), new RightSideView().rightSideView(root));

        root = new TreeNode(0, null, null);
        assertEquals(List.of(0), new RightSideView().rightSideView(root));

        assertEquals(Collections.emptyList(), new RightSideView().rightSideView(null));


    }


}