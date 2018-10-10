### Spiral matrix

> Question - [Spiral Matrix - LeetCode](https://leetcode.com/problems/spiral-matrix/description/)


#####  Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

### Questions?

- Is it a square matrix?

### Working/Thinking
```
[
 [ 1,  2,  3   4],
 [ 5   6   7   8],
 [ 7,  8,  9  10],
 [ 11 12  13  14]
]


-------------------------
Stop Condirion        [1,2,3,4] [8,10,14] [13,12,11] [7,5]  [6,7]  [9]  [8]
top row           1   2                                       3
bottom row        4                         3                            2
left column       0                                   2
right column      4               3                                 2

----------------------------
1 2 3 4 8 10 14 13 12 11 7 5 6 7 9 8
l -> r
t -> b
r -> l
b -> t

reading 1 row
reading 1 column
reading 1 row 
reading 1 column


r = 1 c = 1- 4
c = 3 r = 2- 4
r = 4 c = 3 - 1
c = 1 r = 3 -2
r = 2 c = 2 -3
c = 3 r = 3- 3
r = 3 c = 2-2

Stop condition: trb == brb && lrb == brb

r = trb
R: lcb - rcb
trb ++

c = rcb
R: trb - brb
rcb --

r = brb
R: rcb - lcb
brb --

c = lcb
R: brb - trb
lcb ++

```

### Editorial

This is about maniupulating the indices well and about writing proper code

> O(n^2)  - TIme complexity

### Code 

```
  class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<Integer>();
        int numRows = matrix.length;
        
        if (numRows == 0) {
            return spiral;
        }
        int numColumns = matrix[0].length;
               
        int trb = 0;
        int brb = numRows - 1;
        int lcb = 0;
        int rcb = numColumns - 1;
        int row;
        int column;
        while (trb<=brb && lcb<=rcb) {
            
            row = trb;
            for (int i = lcb; i <= rcb; i++) {
                spiral.add(matrix[row][i]);
            }
            trb += 1;
            if (trb>brb ) {
                break;
            }
            
            column = rcb;
            for (int i = trb; i<=brb; i++) {
                spiral.add(matrix[i][column]);
            }
            rcb -= 1;
            if (lcb>rcb) {
                break;
            }
            
            row = brb;
            for (int i = rcb; i>=lcb; i--) {
                spiral.add(matrix[row][i]);
            }
            brb -= 1;
            if (trb>brb) {
                break;
            }
            
            column = lcb;
            for (int i = brb; i>=trb; i--) {
                spiral.add(matrix[i][column]);
            }
            lcb += 1;
        }
        
        return spiral;
        
    }
}
```
