import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {

    Integer nextElement;
    Iterator<Integer> iterator;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        nextElement = null;
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
       if (nextElement != null) {
           return nextElement;
       }
       if (!hasNext()) {
           return null;
       }

       nextElement = next();
       return nextElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (nextElement != null) {
            Integer temp = nextElement;
            nextElement = null;
            return temp;
        }

        return iterator.next();
    }

    @Override
    public boolean hasNext() {
       return nextElement != null || iterator.hasNext();
    }
}