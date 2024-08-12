# Word Ladder

## Intuition
Intuition is the same as that for the [Minimum Mutation](MinMutation.md) problem

## Different approach
A similar approach would give an O(n^2) solution. In this case, the wordlist can be huge(lesser than 5k).
The quadratic complexity is prohibitive. Construction of an adjacency list representing this graph is not straight 
forward due to the nature of the edges. 

A special technique can be used to exploit the fact that m(lesser than 10) is still small.

A **contrived** adjacency list needs to be constructed. The nodes are going to be all possible
single-character-masked patterns of the words in the wordlist. The values are going to be all words that match these 
masked patterns. 

Consider the following example
```text
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
```

The adjacency list would look like
```text
*it -> hit
h*t -> hit, hot
hi* -> hit
*ot -> hot, dot, lot
ho* -> hot
d*t -> dot
do* -> dog, dot
l*t -> lot
lo* -> lot, log
*og -> log, cog, dog
l*g -> log
d*g -> dog
c*g -> cog
```

A straight forward traversal will not result in a graph at all as the keys are masked patterns and values are actual 
words. A contrived traversal is required where every word dequeued will need to be converted to all possible matchable 
masked patterns.

Say `hot` is initially in the BFS queue. On de-queuing the same explode it to all its matchable masked patterns

```text
hot => *ot, h*t, ho*
```
The valid mutations of `hot` can now be obtained by looking up these masked patterns and will be
```text
dot, lot, hit
``` 

The traversal can thus proceed until the `endWord` is found or the traversal completes.

## Complexity
Construction of adjacency list requires O(nm) only