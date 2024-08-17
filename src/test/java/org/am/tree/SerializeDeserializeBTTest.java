package org.am.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SerializeDeserializeBTTest {

    @Test
    public void test() {
        SerializeDeserializeBT serdesBT = new SerializeDeserializeBT();

        TreeNode root = new TreeNode(1,
                new TreeNode(2, null, null),
                new TreeNode(3,
                        new TreeNode(4, null, null),
                        new TreeNode(5, null, null)
                )
        );
        //assertEquals("1,2,3,null,null,4,5,null,null,null,null,", serdesBT.serialize(serdesBT.deserialize("1,2,3,null,null,4,5")));
        System.out.println(serdesBT.deserialize(serdesBT.serialize(root)));
    }

}