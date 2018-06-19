## [Two Sum](https://leetcode.com/problems/two-sum/description/)

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example
```
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

Solutions

+ Brute force :
  Run two loops and check the sum 
  Complexity - O(n^2)
+ Sorting and two pointers :
  Sort the array and use two pointers, one from start and one from end, depending on the sum
  move either front or back pointer 
  Complexity - O(n^2)
  Problem - when we sort the list, we loose the original index positions of the numbers - Maybe we can retain the priginal array
  as is and store the sorted array in a different list.We can find the original indexes of the element from the original array
  after but it might fail in cases where duplicate elements are present if not hanadled properly 
  Eg: [3,3] target = 6
+ Hash map:
  Store a hash map of the number-index and you can get the result in a single pass of list
