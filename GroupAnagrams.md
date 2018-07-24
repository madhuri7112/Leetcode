## [GroupAnagrams](https://leetcode.com/problems/group-anagrams/description/)

Given an array of strings, group anagrams together.

```
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
```

Questions to Ask:
- Does the strings have only alphabets?
- Case sensitive?

Approaches:

- Naive approach

Initialize output [[]]
For each string, check if it is anagram of first string of each bucket, if it is add to that bucket.If the string does not belong to any bucket,
then create a new bucket with this string.

> Time Complexity:
L -> length of longest word
O(n^2 * L)

> Space Complexity: O(1) if we dont consider the space of the output list

- Hash map with sorting:

Maintain a hashmap with key as sorted string and values as list of its anagrams

> Time Complexity:
L -> length of longest word
O(LlogL)

> Space Complexity: O(N*L)
