## Insert Delete GetRandom O(1)



Qsns

1. Insert as in insert at an index/position?Or can we just insert at end
2. Delete as in delete a specific element or delete element at index?
3. GetRandom - can I use native "rand" function?
4. Do we have any idea about the type of values this data structure can hold?


Working

```
For insert to be O(1) -- array/linked list

For delete to be O(1) --
I need to find the index in O(1) and also delete in O(1)
We need mapping of element-index

For GetRandom to be O(1) -- 
array - get a random index -- retrieve it


store the nums in an arrayList -
maintain a mapping for element, index

Insert - insert at end of list, add mapping to map -- O(1)

Delete - get the index from map, remove it from list and map -- this is O(n)
So instead of deleting the element directly, we swap it with last node and remove last node

Get random - get a random index and return corresponding element

```

## Editorial

1. Use a hash map and arraylist

  - Arraylist to store the actual values.
  - Hashmap to store <value, index> mapping
  - Insert : 
    ```
    insert(val):
      arrayList.add(val)
      hashMap.add(val, arrayList.size()-1)
    ```
  - Delete:
    ```
    delete(val):
      index = hashMap.get(value)
      swap(arrayList, index, lastIndex)
      arrayList.delete(lastIndex, index)      
    ```
  - GetRandom:
    ```
    getRandom():
      index = getRandomVal()
      return arrayList(index)
    ```
    
## Code
```
public class RandomizedSet {
    ArrayList<Integer> nums;
    HashMap<Integer, Integer> locs;
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        nums = new ArrayList<Integer>();
        locs = new HashMap<Integer, Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = locs.containsKey(val);
        if ( contain ) return false;
        locs.put( val, nums.size());
        nums.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean contain = locs.containsKey(val);
        if ( ! contain ) return false;
        int loc = locs.get(val);
        if (loc < nums.size() - 1 ) { // not the last one than swap the last one with this val
            int lastone = nums.get(nums.size() - 1 );
            nums.set( loc , lastone );
            locs.put(lastone, loc);
        }
        locs.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get( rand.nextInt(nums.size()) );
    }
}
```
