import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RevealCards {
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> indicesQueue= new LinkedList<Integer>();
        Arrays.sort(deck);
        for (int i=0; i < deck.length; i++) {
            indicesQueue.add(i);
        }
        int[] result = new int[deck.length];
        int currentIndexInSortedArray = 0;
        while(!indicesQueue.isEmpty()) {
            int nextIndexToPop = indicesQueue.poll();
            result[nextIndexToPop] = deck[currentIndexInSortedArray];
            currentIndexInSortedArray ++;
            if (!indicesQueue.isEmpty()) {
                indicesQueue.add(indicesQueue.poll());
            }
        }
        return  result;
    }

    public static void main(String[] args) {
        RevealCards rc = new RevealCards();
        rc.deckRevealedIncreasing(new int[]{1,2,3});
    }


}
