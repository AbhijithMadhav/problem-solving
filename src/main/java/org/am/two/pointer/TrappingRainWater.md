# [Trapping rainwater](https://leetcode.com/problems/trapping-rain-water/description/)

# Intuition
The Crux is to recognize that water for each position can be calculated iteratively. 

The amount of water that can be stored at a position is determined by the extent of the walls on its left and right. 
Not necessarily the immediate walls, but the wall with the max height on its left and right.

More specifically, the water stored at a position is determined by the smallest of the max walls on the 
left or the right.


## Approach 1: Using extra space
The above intuition leads to the calculation of the max heights on either side of each position.

The Complexity of this will be O(n). There will be three scans required, one to calculate the max height of the wall to 
the left of every position and another one to find the same to the right of every position.

The last iteration will be to calculate the amount of water stored.

This will take up extra space, O(n), to store the left and right max heights.


## Approach 2: No extra space

The area at a position, `i`, is determined by the smallest of its enclosing left or right wall.

If we iterate to a position, `l`, **from the left**, we will know the enclosing left wall, which is the wall with 
the maximum height left of the `l`(`maxLeft`). 

For `maxLeft` to determine the amount of water that can be stored in the current position, the enclosing wall on the 
right needs to be taller than that on the left. We don't know this wall. However, by using the two-pointer technique 
and iterating from the right simultaneously, we will know about the wall with the maximum height to the right of a 
position `r` on the right(`maxRight`).

If `maxLeft` is taller than `maxRight` we can't conclude about the amount of water that can be stored at `l` as the
right enclosing wall to the left of `maxRight` can be higher or lower than `maxLeft`.

But, if `maxLeft` is shorter than `maxRight`, `maxLeft` determines the amount of water that can be stored at `l` for 
two reasons
1. An enclosing right wall to the left of `maxRight` which is taller than `maxRight` would mean that `maxLeft` is 
the shorter of the two enclosing walls
2. An enclosing right wall to the left of `maxRight` which is shorter than `maxRight` would mean that `maxRight` 
is the right enclosing wall. Since `maxLeft` is shorter than `maxRight`, `maxleft` determines the amount of water 
that can be stored at `l`

Similarly, it can be reasoned that the amount of water that can be stored at a position `r` when we traverse from the 
right is determined by its enclosing wall on the right, `maxRight`, if `maxRight` is shorter than `maxLeft`. 
