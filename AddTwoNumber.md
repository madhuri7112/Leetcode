## [Add two numbers in linked list](https://leetcode.com/problems/add-two-numbers/description/)

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.


Solutions:

1. Read two numbers to strings , convert them to numbers and add them , and put them back in linked list

O(d) space O(d) complexity
Also might not work if the numbers are too long.

2. Iterate each node, add them store carry in seperate variable.

Cases to take care:
1. one number is longer than other
2. At the end if carry = 1, wee need to add a node with digit 1

O(n) complexity
O(1) soace if we do not consider the soace of result array
