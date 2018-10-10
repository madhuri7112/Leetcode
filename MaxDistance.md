## Max Distance

> Given an array arr[], find the maximum j – i such that arr[j] > arr[i].

## Maximum Distance

This is the BEST soltion I have come up with
#### Using [Right Max] and two pointers array 

This approach makes use of concepts of two pointers and an auxiallry array.
###### Algo:
- Let the array be chars
- Compute RightMax array where RightMax[i] is the greatest element on right side of chars[i]
- Maintain two pointers pointer1 and pointer2.
- Initialize the pointers to 0 and 1 respectively(Handle edge cases properly)
- Move pointer2 until RightMax[pointer2] < chars[pointer1] -- This means there is no element on right of pointer2 which is greater than chars[pointer1]
- Record the difference in the indices and increament pointer1.
- Repeat the same process and move pointer2 until RightMax[pointer2] < chars[pointer1].Keep track of max difference in the indices.

######  code
```
using System;
public class GFG {
	static public void Main () {
		Console.WriteLine(getMaxDifference(new char[]{'g', 'b', 'c', 'j', 'b', 'd', 'h', 'a'}, 8));
	}
	
	static int max(int x, int y) 
    {
        return x > y ? x : y;
    }
	static int getMaxDifference(char[] chars, int n) {
	    
	    if (n == 0 || n == 1) {
	        return -1;
	    }
	    
	    int[] rightMax = new int[n];
	    int maxTillNow = chars[n-1];
	    for (int i = n-1; i>=0; i--) {
	        maxTillNow = max(maxTillNow, chars[i]);
	        rightMax[i] = maxTillNow;
	    }
	    int pointer1 = 0;
	    int pointer2 = 1;
	    int maxDifference = -1;
	    while(pointer1 < n && pointer2 < n) {
	        while (pointer2 < n && chars[pointer1] < rightMax[pointer2]) {
	            pointer2 ++;
	        }
	        maxDifference = max(maxDifference, pointer2-pointer1-1);
	        pointer1++;
	    }
	    
	    
	    return maxDifference ;
	}
}
```

### OTHER METHODS

#### Method 1: Brute Force

For each alphabet, find the farthest alphabet which is greater than the current alphabet

Pseudo code

```
MaxDistance(alphabetList) {
  len = alphabetList.length
  maxDistance = -1
  
  for (i=0; i<len; i++) {
    j = n - 1
    while(j > i):
        if alphabetList[j] > alphabetList[i] and maxDiff < (j - i):
            maxDiff = j - i;
        j -= 1
  }
        
     
  return maxDiff
}
```

> Time Complexity - O(n^2)
> Space Complexity O(1)

#### Method 2: Hashmap

Use hashmap ( alphabet - index) to store indices of the alphabets in the array.
Then traverse through the array, for each alphabet check the indices of all the alphabets greater than the current alphabet and keep track of the difference of indices.

Pseudo code:
```
FindMaxDistance(alphabetList) {
  HashMap<Character, Integer> alphabetIndices = new HashMap<Character, Integer>();
  
  // Store the indices of alphabets in hashmap
  for(i=0; i< alphabetList.length; i++) {
    alphabetIndices.put(alphabetList[i], i);
  }
  
  maxDistance = -1
  // Iterate through the list
  for(i=0; i < alphabetList.lenght; i++) {
       currentChar = alphabetList[i];
       
       //Iterate from current char to 'z'
       for(chr = currentChar; chr <= 'z'; chr ++) {
          if (alphabetIndices.get(chr) && alphabetIndices.get(chr) > i) {
            maxDistance = max(maxDistance, alphabetIndices.get(chr))
          }
          
       } 
       
  }
  
  return maxDistance
  
}
```

> Time Complexity: O(n)
> SpaceComplexity: O(1)
> Limitations:  Will NOT work if array has duplicates.

