import java.util.ArrayList;
import java.util.HashMap;

public class SortByFreq {
    public String frequencySort(String s) {
        HashMap<Character, Integer> frequency = new HashMap<>();

        for(char c: s.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0)+1);
        }

        HashMap<Integer, ArrayList<Character>> reverseFreq = new HashMap<>();

        for (char c: frequency.keySet()) {
            int freq = frequency.get(c);
            if (!reverseFreq.containsKey(freq)) {
                reverseFreq.put(freq, new ArrayList<>());
            }
            reverseFreq.get(freq).add(c);
        }

        StringBuffer sb = new StringBuffer();

        for (int i=s.length()-1; i >=0 ;i-- ) {
            if (reverseFreq.containsKey(i)) {
                for (Character c: reverseFreq.get(i)) {
                    for (int j=0; j<i; j++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }
}
