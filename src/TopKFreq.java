import java.util.*;

public class TopKFreq {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num: nums) {
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(k, (e1, e2) ->  e2.getValue() - e1.getValue());

        for (Map.Entry<Integer, Integer> en: freq.entrySet()) {
            maxHeap.add(en);
        }

        List<Integer> result = new ArrayList<>();

        while (result.size() < k && !maxHeap.isEmpty()) {
            result.add(maxHeap.poll().getKey());
        }

        return result;
    }
}
