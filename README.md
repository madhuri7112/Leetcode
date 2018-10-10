# AlgoEditorials
Editorials for Algorithmic problems explaining different approaches to a problem along with their complexities

## Index

1. [Paradigms](#paradigms)
2. [Edge cases to take care](#edge-cases-to-take-care)
3. [Questions that can be asked](#questions-that-can-be-asked)


## Paradigms

| Paradigm | Concept | Examples |
| -------- | ------- | -------- |
| [two pointer approach](#two-pointer-approach) | Use two pointers for the array and move the pointers based on some decission | --- |
| [sliding window](#sliding-window) | Similar to two pointer approach but usually the window (distace between two pointers) is fixed and the window is moved in a direction based on some decission | [ par ](#algothoughts)
| [use array as position array](#array-as-position-array) | use index of the array to flag the value of index | used in finding duplicates in array etc |
| [Computing left/right result arrays](#computing-left-or-right-result-arrays) | Compute left result or right result arrays| |
| Divide and conquer | Divide the given problem into sub problems and solve the subproblems recursively | 
| Greedy | Choose the solution based on the first best way possible| https://www.geeksforgeeks.org/greedy-algorithms/ |
| Dyanamic programming | Identify subproblems and try to solve the given problem with the help of the subproblems in a top down approach |https://www.geeksforgeeks.org/dynamic-programming/ |

### Two pointer approach

- Typically used for arrays
- Usually used in the following ways.
1. Two pointers start from either end of an array and move according to a condition
2. one is slow pointer and another is fast pointer.

Further read: 
[interviewbit-two-pointer](https://www.interviewbit.com/tutorial/two-pointers/)
[leetcode-two pointer](https://leetcode.com/articles/two-pointer-technique/)

### Sliding window

Generally speaking a sliding window is a sub-list that runs over an underlying collection. I.e., if you have an array like
```
[a b c d e f g h]
a sliding window of size 3 would run over it like

[a b c]
  [b c d]
    [c d e]
      [d e f]
        [e f g]
          [f g h]
```

This is useful if you for instance want to compute a running average, or if you want to create a set of all adjacent pairs etc.
(Source: Stackoverflow)
More Information : https://www.geeksforgeeks.org/window-sliding-technique/

### Array as position array
[To Do] 


### Computing left or right result arrays

#### Examples:
[Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/description/)

## Edge cases to take care

### General

1. Handle null object
2. Look for "index out of bounds" exception
3. Take care of -ve numbers


### Strings/Arrays

1. Handle zero length string/array
2. Handle empty string
3. Handle string with length 1 (particularly important in two pointer approach)


## Questions that can be asked

### General

1. Ask for expected time complexity
2. Ask for expected space complexity

### Input

1. If it is number - number +ve/-ve/integer/float?
2. Are you testing the script for multiple inputs or single input? (Intention is: sometimes you can use hashmap for storing the result and use it as a look up in case multiple inputs are being given)

### Strings/Arrays

1. Characters only a-z ?
2. Are there any duplicates present?
3. All the numbers positive/negative?
4. All the numbers integers or float?
5. Ask if array is sorted


