# Valid Tree
## Intuition

A graph with n vertices and n - 1 edges is a tree. A graph with n - 1 edges, however, may have cycles and unconnected 
vertices.

So in addition to checking for n - 1 edges, a check for a cycle needs to be done

A BFS or a DFS can do a check for a cycle traversal. However, since the input is a set of edges and not an adjacency 
list, a union-find algorithm is more appropriate.

In case the graph is a tree, a find on the vertices of any edge, before their union, is expected to return different 
component ids. 

So the algorithm would be to check if the vertices belong to the same component before union-ing them. In case they 
belong to the same component, there is another previously processed edge which connects them and has unionized 
them before this edge was processed


