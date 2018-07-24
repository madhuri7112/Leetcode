## [Remove Duplicates from sorted array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/)

Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

```
Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
```

Solutions:

Questions to ask:
1.Should the order be maintained?
2.Do you need only the length returned or does the array also matter - if it is only lenght - just need to find the number of unique elements in the list


Thought process:

- all the duplicate elements occur together as it is a sorted array

Method 1:

Initialize an output array.
traverse the list and copy the elements to output array only if the element != prev element

```
def removeDuplicate(inp):
    output = []
    output.append(inp[0])
    for index in range(1, len(inp)):
         if inp[index] != inp[index-1]:
              output.append(inp[index])
    
    return output
```
> Time Complexity: O(n)

> Space Complexity: O(n)

Method 2:

Two pointers approach

Intialize two pointers, one for reading and one for writing.
Move the read pointer until it find a new number and write the new number at the index of write pointer.

```
def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) == 0 or len(nums) == 1:
            return len(nums)
        
        readPointer = 1
        writePointer = 0
        
        while (readPointer < len(nums)):
            if (nums[readPointer] != nums[writePointer]):
                writePointer += 1
                nums[writePointer] = nums[readPointer]
            readPointer += 1
        
        return writePointer + 1
```
Java Code
```
public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        
        int readPointer = 1;
        int writePointer = 0;
        
        while(readPointer < nums.length) {
            
            if (nums[readPointer] != nums[writePointer]) {
                writePointer += 1;
                nums[writePointer] = nums[readPointer];
                
            }
            
            readPointer += 1;
        }
        
        return writePointer + 1;
    }
```

> Time Complexity: O(n)

> Space Complexity: O(1)
