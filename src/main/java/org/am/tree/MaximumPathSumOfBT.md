# [Maximum path sum of a binary tree](https://leetcode.com/problems/binary-tree-maximum-path-sum/description/)

## Intuition
Find the maximum path sum passing through a particular node. 
```text
maxPathSum(node1), maxPathSum(node2), ..., maxPathSum(node_n)
```

The maximum path sum of the BT is the maximum of all such maximums, i.e., global maximum

## Solution
The solution is more involved. Consider the elements needed to calculate the max path sum passing through a node. This
path sum is the maximum of
1. Just the node itself
2. A path passing through its left subtree and the node
3. A path passing through its right subtree and the node
4. A path passing through both its left and right subtree and the node

All the above can be used to update the global maximum at each local node.

The subtlety is that the calculation of 2, 3 and 4 require results from sub-problems.
These sub-problems are particular. To calculate the max path sum passing through a node, we need max path sums passing 
through its left and right subtrees. 

This should not include the max path sum present in the subtrees without passing through the roots of the subtree. 
The 4th option above falls into the later category. Since it is a path which branches to the left and right subtree, it
can't be used to calculate the max paths passing through its parent and ancestors.

Thus the implementation keeps track of a local and global maximum. The local maximum is one which can be used by the 
parent node to calculate its local maximum.

