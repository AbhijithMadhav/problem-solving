# [House Robber](https://leetcode.com/problems/house-robber/)

## Intuition
There are a subset of houses that the robber can target as long as the subset does not contain two consecutive houses. 

# Brute force
The problem reduces to finding such subsets and then determining the subset which gives the maximum value(as per 
the sum of its elements).

The number of possible subsets for n elements is 2<sup>n</sup>. In this case it will be slightly less than that to 
accommodate  the condition of 'no consecutive elements'. It will still be O(2<sup>n</sup>). The time complexity is 
proportional to subset generation.

# Overlapping sub-problems
Consider the set `{0, 1, 2, 3, 4, 5}` and the subsets `{0, 3, 5}`, `{1, 3, 5}` and `{3, 5}`. `{3, 5}` is 
a subset of `{0, 3, 5}` and of `{1, 3, 5}`.

The solution of subproblems, `{3, 5}`, can be reused to solve for its supersets.
