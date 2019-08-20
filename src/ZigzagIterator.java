import java.util.ArrayList;
import java.util.List;

public class ZigzagIterator {

    List<Integer> list1 = new ArrayList<Integer>();
    List<Integer> list2 = new ArrayList<Integer>();
    boolean firstListTurn = true;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        list1.addAll(v1);
        list2.addAll(v2);
    }

    public int next() {
        int next;
        if (firstListTurn) {
            if (!list1.isEmpty()) {
                next = list1.remove(0);
            } else {
                next = list2.remove(0);
            }
        } else {
            if (!list2.isEmpty()) {
                next = list2.remove(0);
            } else {
                next = list1.remove(0);
            }
        }

        firstListTurn = !firstListTurn;
        return next;
    }

    public boolean hasNext() {
       return !(list2.isEmpty() && list1.isEmpty());
    }
}
