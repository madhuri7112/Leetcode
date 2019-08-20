import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class HitCounter {
    /** Initialize your data structure here. */
    Queue<Integer> queue = new ArrayDeque<>();
    public HitCounter() {

    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
       queue.add(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
      while (!queue.isEmpty() && queue.peek() <= timestamp-300) {
          queue.poll();
      }
      return queue.size();
    }
}
