import java.util.*;

class RandomizedCollection {

    ArrayList<Integer> values;
    HashMap<Integer, HashSet<Integer>> index;
    Random r;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        values = new ArrayList<>();
        index = new HashMap<>();
        r = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean alreadyPresent = !index.containsKey(val);

        values.add(val);
        HashSet<Integer> indices = new HashSet<>(Arrays.asList(values.size()-1));
        indices.addAll(index.getOrDefault(val, new HashSet<>()));
        index.put(val, indices);
        return alreadyPresent;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!index.containsKey(val)) {
            return false;
        }

        int indexToDelete = index.get(val).iterator().next();
        int lastElement = values.get(values.size()-1);
        values.set(indexToDelete, lastElement);
        index.get(val).remove(indexToDelete);
        index.get(lastElement).add(indexToDelete);
        index.get(lastElement).remove(values.size()-1);

        values.remove(values.size()-1);

        if (index.get(val).isEmpty()) {
            index.remove(val);
        }
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
       int randomIndex = r.nextInt(values.size());

       return values.get(randomIndex);
    }

    public static void main(String[] args) {
        RandomizedCollection rc = new RandomizedCollection();
        rc.insert(1);
        rc.insert(2);
        rc.remove(1);
        rc.remove(2);
        rc.remove(1);
        System.out.println(rc.values);
    }


}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */