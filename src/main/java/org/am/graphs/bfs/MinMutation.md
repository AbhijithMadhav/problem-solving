# Minimum genetic mutations

## Intuition
The genes in the bank can be seen as nodes of a graph. An edge exists if a gene can mutate into another, i.e., the genes
differ by one character

The shortest mutation sequence is now the shortest path from the start gene to the end gene. This shortest path can be 
determined by a BFS of this graph.

As always, determining the shortest path would mean a layered BFS traversal where all queued neighbour nodes are 
processed atomically to enable the correct increment of the 'length' variable.

## Approach
Construction of an adjacency list representing this graph is not straight forward due to the nature of the edges. 

One way to go about this is an O(n^2) double loop over all the genes to determine the neighbors for each gene node.
Assuming a word length of m, which it is 8 in this case, the complexity would be O(m * n^2).

The BFS would take a further O(n) making the overall complexity to be O(m * n^2). Given that n is small, lesser than 10,
the quadratic complexity is bearable

