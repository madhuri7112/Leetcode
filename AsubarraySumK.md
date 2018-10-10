## Subarray sum equals k

> [Subarray Sum Equals K - LeetCode](https://leetcode.com/problems/subarray-sum-equals-k/description/)
> 

Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.


### Questions to ask
1. Are integers +ve?  -- No
2. Should the subarray be continous?  -- Yes
3. Can array be empty? -- Yes
4. Are the numbers sorted? -- N0



---- 
Working
```
[1,1,1], k = 2

Ans = 2

[1,3,4,5,6] k = 2

Ans = [1,3] [4] -- 2

Subarray - startINdex, endIndex

O(n^2) subarrays
iterate through all the subarrays and find count 
O(n^2) complecity O(1) space


[1 3 4 5 6]

Sum(3-6) = sum(1-6) - 1
Sum(i-j) = sum(0-j) - sum(0-i)

      1 3 4  5  6  -- 19
Sum : 1 4 8 13 19
      |         |
      s         e
      will work only if this is sorted
      
      if there are -ve nums- not sorted - not work
      s2 - s1 = k
      3 -1 4 3 -2
      3  2 5 8  6
      
      HashMap -> sum, Array of indices
      
      Traverse through sum array, check if k + currentSUm is in hashmap and if present, check how many corresponding indices are greater than the currentINdex
      
      Might increase complexity if there are lot of duplicates in sum array
      
      CHECKING HASHMAP ON THE GO WHILE YOU CREATE IT
      
    
      
      

```
> Thing to notice is as you traverse the array the sums which are already present in hashmap are always of previous index
> 


### EDITORIAL

1. Naive solution
  - Run two loops, find sum for each subarray
  - Increament whenever sum = k

> O(n^3) - time complexity
> O(n^2) if sum is calculated wisely using sum of previous arrays
> 

2. Use hashmap to store sumUntilIndex
  - initialize a variable "currentSum" = 0.
  - Traverse the array and check if k+currentSum is present in hashmap.If present, then return the corresponding indices, else store the currentSum, index in hasmap and continue the process.
 > O(n) -- Space complexity
 > O(n) -- Time complexity
 
Code
```
class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
    
        int[] sumArray = new int[nums.length];
        HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
        
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            sumArray[i] = sum;
        }
        int totalCount = 0;
        sumMap.put(0,1);
        for (int currentSum: sumArray) {
            totalCount += sumMap.getOrDefault(currentSum-k, 0);
            sumMap.put(currentSum, sumMap.getOrDefault(currentSum, 0)+1);   
        }
        
        return totalCount;
    }
}
```
