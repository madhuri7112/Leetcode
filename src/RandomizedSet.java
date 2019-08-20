import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {


    HashMap<Integer, Integer> index;
    ArrayList<Integer> values;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        values = new ArrayList<>();
        index = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (index.containsKey(val)) {
            return false;
        }
        values.add(val);
        index.put(val, values.size()-1);

        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
       if (!index.containsKey(val)) {
           return false;
       }
       int lastValue = values.get(values.size()-1);
       int indexToDelete = index.get(val);
       values.set(indexToDelete, lastValue);
       index.put(lastValue, indexToDelete);
       index.remove(val);
       values.remove(values.size()-1);

       return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
      return values.get(random.nextInt(values.size()));
    }

    public static void main(String[] args) {
        RandomizedSet rc = new RandomizedSet();
        rc.insert(0);
        System.out.println(rc.values);
        rc.remove(0);
        System.out.println(rc.values);
        rc.insert(-1);
        System.out.println(rc.values);
        rc.remove(0);

        System.out.println(rc.values);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */