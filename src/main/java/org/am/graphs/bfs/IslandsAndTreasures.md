## Intuition

Shortest paths to treasures can be found by BFS starting from every land cell. Instead of repeating BFS from every land 
cell, a single multi-source BFS from all land cells together is more efficient. 

Since the distance to the treasure cells needs to be marked on the land cells, a multi-source BFS from all the treasure 
cells is necessary. This will help maintain a distance counter which can be used to mark the distance of the 
land cells from the treasure.

All the neighbouring nodes need to be processed at once because we need to mark the distance of the land nodes from the 
treasure.

Every land cell is marked with the distance from its nearest treasure cell due to the BFS traversal from that treasure
cell reaching it before than one from a further treasure cell. The use of the `visited` marker prevents this value from
being overwritten when the later traversal reaches the cell in question.

## Time complexity
Same as a single BFS, O(m*n), for traversing the matrix once

## Space complexity
Same as a single BFS, O(m*n), for storing the 'visited' information


