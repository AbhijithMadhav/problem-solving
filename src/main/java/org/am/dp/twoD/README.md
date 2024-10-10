# Distinct subsequences
![distinct subsequences](distinct-subsequences.drawio.svg)

## Formulation
```text
Let c[i, j] be the number of distinct subsequences, t[j...m] in s[i...n]

c[i, j] = 1 if i == n and j == m and s[i] == t[j]

c[i, j] = 0 if i == n and j == m and s[i] != t[j]

c[i, j] = c[i + 1, j + 1] + c[i + 1, j] if i < n and j < m and s[i] == t[j]

c[i, j] = c[i + 1, j] if i < n and j < m and s[i] != t[j]
```

## Complexity
O(2<sup>n</sup>) without memoization. 
The depth of the tree will be `n`, the length of s, in the worst case.
This is because we scan through the entire length of s trying to match for t.
The base is two because we make the choice of matching or not matching `s[i]` and `t[j]` even when they can be matched.


With memozation, the number of recursive calls in the worst case will be one for every pair of indexes of s and t.

⇒ O(m*n)
