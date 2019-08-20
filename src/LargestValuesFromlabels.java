import java.util.*;

public class LargestValuesFromlabels {
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        PriorityQueue<int[]> priorityHeap = new PriorityQueue<>(Comparator.comparingInt(li -> -1*li[0]));

        for (int i=0; i<values.length; i++) {
            priorityHeap.add(new int[]{values[i], labels[i]});
        }

        HashMap<Integer, Integer> labesUsedCount = new HashMap<>();

        int totalCount = 0;
        int totalSum = 0;
        while (totalCount < num_wanted && !priorityHeap.isEmpty()) {
            int[] nextElement = priorityHeap.poll();

            if (labesUsedCount.getOrDefault(nextElement[1], 0) >= use_limit) {
                continue;
            }
            totalCount ++;
            totalSum += nextElement[0];
            labesUsedCount.put(nextElement[1], labesUsedCount.getOrDefault(nextElement[1], 0) + 1);
        }

        return totalSum;
    }
}
