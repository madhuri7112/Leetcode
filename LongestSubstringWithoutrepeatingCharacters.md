## Longest substring without repeating characters 

> [Longest Substring Without Repeating Characters - LeetCode](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/)
> 

-----------
Working
```
abcabcb
l = 3 result = abc

abcabcbb

a - Y - 1
ab - Y - 2
abc - Y - 3
abca - N
abcab - N
abcabc - N
abcabcb - N

b - Y - 1
bc - 2
bca - 3
bcab - N
bcabc - N
bcabcb - N

c - 1
ca - 2
cab - 3

a - Y - 1
ab - Y - 2
abc - Y - 3

abcdaeuj

use two pointers, increment 2nd pointer until you find repetition.
Then increase 1st pointer until the duplicate char is removed


```

### Editorial

1. Naive Solution:
- Find every substring which has no repetations, and find the longest one.

> O(n^2) -- Time complexity
> O(n) -- Space complexity

2. Two pointer Approach:
- Maintain two pointers, startPointer and endPointer
- Increment endPOinter until you find a repetation.Stop when there is repetation and record the length (Use hash set to store the characters)
- Increment startPOinter until the repetation is removed and repeat the process
- Keep track of maxLength

> O(n) -- Time
> O(n) -- Space
> Traverses the array 2 times.

3. Hash Table
  - Store the character,index of the character in a hashmap.
  - WHen you encounter a repeated character, the startPointer can be moved directly to the index using the hashmap

> O(n) - Time Complexity
> O(n) - Space complexity
> Traverses the array only once
> 

### Code 
```
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        
        if (len == 0) {
            return 0;
        }
        
        int startPointer = 0;
        int endPointer = 0;
        int maxLen = 0;
        HashSet<Character> chars = new HashSet<Character>();
        
        while (endPointer < len) {
            
            while(endPointer < len && !chars.contains(s.charAt(endPointer)) ) {
                System.out.println(startPointer + " " + endPointer);
                chars.add(s.charAt(endPointer));
                endPointer += 1;
            }
            
            int l = endPointer - startPointer;
            maxLen = Math.max(maxLen, l);
            if (endPointer == len) {
                break;
            }
            while (s.charAt(startPointer) != s.charAt(endPointer)) {
                chars.remove(s.charAt(startPointer));
                startPointer += 1;
            }
            chars.remove(s.charAt(startPointer));
            startPointer += 1;
            
            // do {
            //     chars.remove(s.charAt(startPointer));
            //     startPointer += 1;
            // } while (s.charAt(startPointer) != s.charAt(endPointer)) 
           // chars.remove(s.charAt(startPointer));
           // startPointer += 1;
        }
        
        return maxLen;
    }
}
```
