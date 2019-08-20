import java.util.*;

public class KFreqWords {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> freq = new HashMap<>();

        for (String word: words) {
            freq.put(word, freq.getOrDefault(word, 0)+1);
        }

        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(k, this::compare);

        for (Map.Entry<String, Integer> en: freq.entrySet()) {
            maxHeap.add(en);
        }

        List<String> result = new ArrayList<>();

        while (result.size() < k && !maxHeap.isEmpty()) {
            result.add(maxHeap.poll().getKey());
        }

        return result;
    }

    private int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
        if (m2.getValue() == m1.getValue()) {
            return m1.getKey().compareTo(m2.getKey());
        }

        return m2.getValue() - m1.getValue();
    }
}
