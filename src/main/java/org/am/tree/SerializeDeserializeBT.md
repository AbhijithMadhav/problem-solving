# Serialize and deserialize a Binary tree

## Intuition
Serializing is pretty straightforward. Any one of the tree traversal methods(inorder, preorder or postorder) should 
yield a representation of the tree. Working back from that representation to an actual tree seems impossible due to the 
ambiguity. 

Consider the representation "1, 2, 3". Which of the three nodes is the root? Seems difficult to infer if the 
traversal methods are one of the above.

With a level order traversal(bfs) there will be an unambiguous interpretation. '1' has to be the root.

## Solution
As indicated above, BFS is used for serialization. 

What is not obvious is that a BFS based iteration helps with deserialization too. 

