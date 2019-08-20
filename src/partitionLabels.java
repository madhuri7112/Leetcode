import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class partitionLabels {
    public List<Integer> partitionLabels(String S) {
        HashMap<Character, Integer> lastIndex = new HashMap<>();
        char[] chars = S.toCharArray();
        for (int i=0; i< chars.length; i++) {
            lastIndex.put(chars[i], i);
        }
        int last = 0;
        int start = 0;
        List<Integer> output = new ArrayList<>();
        for (int i=0; i< S.length(); i++) {
            last = Math.max(last, lastIndex.get(S.charAt(i)));
            if (last == i) {
                output.add(last-start+1);
                start = last+1;
            }
        }
        return output;
    }


}
