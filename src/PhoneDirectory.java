import java.util.HashSet;

public class  PhoneDirectory {

    HashSet<Integer> availableNumbers;
    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
       availableNumbers = new HashSet<>(maxNumbers);
       for (int i=0; i < maxNumbers; i++) {
           availableNumbers.add(i);
       }
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
       if (availableNumbers.isEmpty()) {
           return -1;
       }
       int nextNum = availableNumbers.iterator().next();
       availableNumbers.remove(nextNum);

       return nextNum;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return availableNumbers.contains(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
      availableNumbers.add(number);
    }
}


