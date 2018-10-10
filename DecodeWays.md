### Decode Ways

> [Decode Ways - LeetCode](https://leetcode.com/problems/decode-ways/description/)
> 
Working 
```
A -> 1
B -> 2
C -> 3

Z -> 26


12

AB || L -- 2ways

226

nW(226)
= nW(26) + nW(6)

DP:


Nw(index):

Nw(l) :
  if word[l] != 0:
      return Nw(l-1) + Nw(l-2)
  else if word[l]
      return Nw(l-2)

BASE CASES
len <= 2

len == 2
c=0
n[0] !=0 : c++
n[01] <=26 && n[0]!=0 : c++

len == 1

n[0]>=0
return 1
```
 
### Editorial

1. Dynamic Programming/Recursion with memoization:
    It works on the following logic:
    ```
      Nw(l) :
        if word[l] is valid character:
           return Nw(l-1) + Nw(l-2)
        else if word[l],word[l-1] is valid:
           return Nw(l-2)
  ```
  Handle base cases with len = 1, 2
  
  > Time Complexity: O(n)
  > Space Complexity: O(n)
