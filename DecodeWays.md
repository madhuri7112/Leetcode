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

### Code (Can be improved)
```
  class Solution {
    
    public int decodingUtil(String s, int index, int[] decodings) {
        int len = s.length();
        if (decodings[index] != -1) {
            return decodings[index];
        }
        int count = 0;
        
        if (index == len-1) {
            
            if (Integer.parseInt(s.charAt(index)+"") > 0) {
                decodings[index] = 1;
                return 1;
            } else {
                decodings[index] = 0;
                return 0;
            }
            
        } else if (index == len-2) {
             count = 0;
            
            if (Integer.parseInt(s.charAt(index)+"") != 0 && Integer.parseInt(s.substring(len-2)) <=26) {
                count += 1;
            }
            if ( Integer.parseInt(s.charAt(index)+"") != 0 && Integer.parseInt(s.charAt(index+1)+"") != 0 ) {
                    count += 1;
            }
                       
            decodings[index] = count;
            return count;
            
        } else {
            
             count = 0;
            if (Integer.parseInt(s.charAt(index)+"") > 0) {
                count = count + decodingUtil(s, index+1, decodings);
            }
            if (Integer.parseInt(s.charAt(index)+"") > 0 && Integer.parseInt(s.substring(index, index+2)) <=26 ) {
                count = count + decodingUtil(s, index+2, decodings);
            }
            decodings[index] = count;
            return count;
            
        }
    }
    
    public int numDecodings(String s) {
        
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        
        int[] nDecodings = new int[len];
        Arrays.fill(nDecodings, -1);
        
        return decodingUtil(s, 0, nDecodings);
    }
}
```
