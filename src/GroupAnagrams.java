import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str: strs) {

            char[] sortedChars = str.toCharArray();
            Arrays.sort(sortedChars);
            String key = new String(sortedChars);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                map.put(key, new ArrayList<>(Arrays.asList(str)));
            }
        }
        System.out.println(map);
        List<List<String>> output = new ArrayList<List<String>>();

        for (String key : map.keySet()) {
            output.add(map.get(key));
        }
        return output;

    }

    public static void main(String[] args) {
        String[] atrs = {"eat","tea","tan","ate","nat","bat"};
        new GroupAnagrams().groupAnagrams(atrs);
    }
}
