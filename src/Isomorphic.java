import java.util.HashMap;
import java.util.HashSet;

public class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> matching = new HashMap<>();
        HashSet<Character> mappedChars = new HashSet<>();
        for (int i=0; i<s.length(); i++) {
            char first = s.charAt(i);
            char second = t.charAt(i);
            if (matching.containsKey(first)) {
                if (matching.get(first) == second) {
                    continue;
                }
                return false;
            } else {
                if (mappedChars.contains(second)) {
                    return false;
                }
                matching.put(first, second);
                mappedChars.add(second);
            }
        }

        return true;
    }
}
