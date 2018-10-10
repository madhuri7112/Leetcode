## ZigZagPattern

> [ZigZag Conversion - LeetCode](https://leetcode.com/problems/zigzag-conversion/description/)
> 
### Working

```
PAYPALISHIRING - R = 3

P   A   H   N
A P L S I I G
Y   I   R

Result - PAHNAPLSIIGYIR

PAYPALISHIRING - R = 4

P     I     N
A   L S   I G
Y A   H R
P     I

Result - PINALSIGYAHRPI

1st row - gap = 5
2nd row   gap = 3,1
3rd row   gap = 1,3
4th row   gap = 5

R = 5

C1           C9              C17
C2        C8 C10         C16
C3     C7    C11     C15
C4  C6       C12 C14
C5           C13

1sr row gap = 7
2nd row gap = 5,1
3rd row gap = 3,3
4th row gap = 1,5
5th row gap = 7

1st element - 2*(5-1) -1, 

rth row start with rth element -
2*(R-r) - 1, 2*(r-1) - 1

Handle 1st and last cases carefully

```

### EDITORIAL

1.Using auxilary arraylists
   - Initialize R arraylists, traverse through the string and put the characters in the arraylist one after the other.
  > O(n) -- Space complexity
  > O(n) -- Time complexity
  > 
2. Figuring out a pattern
  ```
  For rth row the elements to be added are at gaps
  2*(R-r) - 1, 2*(r-1)-1
  Handle first and last row carefully
  ```
  > O(n) -- Time complexity
  > O(1) -- Space complexity
  > 

### CODE

```
class Solution:
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        if (numRows == 1) :
            return s
        n = len(s)
        result = ""
        distance = 2*numRows - 2
        for start in range(numRows):
            ptr = start
            
            while (ptr < n):
                result += s[ptr]
                if (start != 0 and start != numRows-1 and (ptr + 2*(numRows-start) -2 < n)):
                    result += s[ptr + 2*(numRows-start) -2]
                    
                ptr += distance
                
        return result
                
```

