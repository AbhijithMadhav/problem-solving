# Graph clone

## Intuition
Traverse the original graph and construct the clone. DFS or BFS could be chosen. BFS is the chosen one here.

A `Node` will typically be a neighbor of multiple others nodes. A `nodeMap` will help reference the same cloned node.
This is necessary to construct the neighbor list for every node as there might be paths from multiple nodes to a node.

While traversing and cloning the graph consider an edge v->w. The adjecency list must contain the w neighbor for v and 
vice-verse(which can be missed);