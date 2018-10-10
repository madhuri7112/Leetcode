### Maximum Difference

> Given an array arr[] of integers, find out the maximum difference between any two elements such that larger element appears after the smaller number.


#### 1. Brute Force

- Run two loops
- Pick each character in the outer loop and in the second loop, pick the characters present to right of the current character and calculate the difference
- Keep track of the max Difference

###### Code
```
static int maxDiff(char[] arr, int n)
    {
        int maxDiff = arr[1] - arr[0];
        int i, j;
        for (i = 0; i < n; i++) {
            for (j = i + 1; j < n; j++) {
                if (arr[j] - arr[i] > maxDiff)
                    maxDiff = arr[j] - arr[i];
            }
        }
        return maxDiff;
    }
```
> Time Complexity: O(n^2)
> Space Complexity: O(1)
>

#### 2. Using RightMax variable

- Start from the rightmost character and maintain a variable which keeps track of the largest character until now.
- At every step calculate the difference between the current character and the currentLargestCharacter and keep track of maxDifference

###### Code
```
static int getMaxDiff(char[] arr, int n)
	{
	    if (n == 0) {
	        return -1;
	    }
	    int maxDiff = -1; 
	    int maxRight = arr[n-1]; 
	 
	    for (int i = n-2; i >= 0; i--)
	    {
	        if (arr[i] > maxRight)
	            maxRight = arr[i];
	        else
	        {
	            int diff = maxRight - arr[i] - 1;
	            if (diff > maxDiff)
	            {
	                maxDiff = diff;
	            }
	        }
	    }
	    return maxDiff;
	}
```

> Time complexity: O(n)
> Space complexity: O(1)
> 
