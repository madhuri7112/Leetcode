# Maximum product Subarray

> [Maximum Product Subarray - LeetCode](https://leetcode.com/problems/maximum-product-subarray/description/)

> Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.


#### Questions

1. Are all elements "integers"?
2. Are all elements positive integers? - If yes - just return entire array
3. Do you need "contiguous" subarray
4. Can the subarray be empty? 

#### Working

```
[2 3 4 5]
Ans - [2 3 4 5]

[-2 -3 -4 -5 -6]
Ans - length is even - just return entire array
      length is odd  - leave the min number of a[0], a[len-1]
      
[2 3 5 -6 4]

solutions:
    total subarrays - startINdex-endIndex - O(n^2)
    each subarray - result - O(n)
    find max
    O(n^3)
    
    -2              p=-2
    -2 -3           p=6
    -2 -3 -4        p=-24
    -2 -3 -4 -5
    -2 -3 -4 -5 -6  p = 24*5*6
    
    
    Remove O(n) complexity
    O(n^2)
    
[-2 -3 -4 -5 -6]
-2 6 -24 120 -720

Find two indices whose division is maximum -  O(n^2)

[-2 -3 -4 -5 -6]

      -2  -4  -5  

Min:  -2  -4  -40  
Max:  -2  8   20



    
```


### Editorial

#### 1. Naive:
  - Find all subarrays - O(n^2) subarrays
  - Find product of each subarray - O(n) each subarray
  - Find max product

> O(n^3) time complexity
> 

#### 2. little improved naive
  - Instead of finding product for each subarray seperately, find product as you make the subarrays and use prev subarrays product
   ```
   Eg:  -2  3  5  6 7
   Subarrays              Product = Prevprod*a[i]
   -2                           -2
   -2 3                         -2*3 = -6
   -2 3 5                       -6*5 = -30
   -2 3 5 6                     -30*6 = -180
  ```
  - WIll reduce the extra O(n) complexity
> O(n^2) time complexity

#### 3. Reduce this to division problem
  - Find product of numbers from index 1 to every i and then it reduces to finding two indeces whose division leads to max number

> O(n^2) -- time complexity
> 

#### 4. Dynamic programming

  - Find min product and max product ending at every index, keep track of max of maxProducts
```
  currentMin = min (prevMin*currentNum, prevMax*currentNum, currentNum)
  currentMax = max (prevMin*currentNum, prevMax*currentNum, currentNum)
  globalMax = max(globalMax, currentMax)
```

currentMax == prevMin*currentNum when currentNum is -ve

currentMax == prevMax*currentNum when currentNum is +ve

currentMax == currentNum when currentNum is +ve and both (prevMin, prevMax) are -ve

> O(n) - Time complexity
> O(1) - Space complexity
> 

### Code
```
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int prevMinEndingHere = nums[0];
        int prevMaxEndingHere = nums[0];
        int maxProductGlobal = nums[0];
        
        for (int i=1;i<nums.length;i++) {
            int currentMaxEndingHere = Collections.max(Arrays.asList(prevMinEndingHere*nums[i], prevMaxEndingHere*nums[i], nums[i]));
            int currentMinEndingHere = Collections.min(Arrays.asList(prevMinEndingHere*nums[i], prevMaxEndingHere*nums[i], nums[i]));
            maxProductGlobal = Math.max(maxProductGlobal, currentMaxEndingHere);
            prevMinEndingHere = currentMinEndingHere;
            prevMaxEndingHere = currentMaxEndingHere;          
        }
        
        return maxProductGlobal;
    }
}
```


