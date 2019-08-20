import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationPhone {
    HashMap<Character, List<Character>> keypad = new HashMap<>();
    public List<String> letterCombinations(String digits) {

        keypad.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
        keypad.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
        keypad.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
        keypad.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
        keypad.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
        keypad.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
        keypad.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
        keypad.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));

        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        util(digits, new StringBuffer(), 0, result);

        return result;
    }

    private void util(String digits, StringBuffer current, int index, List<String> result) {
        if (index >= digits.length()) {
            result.add(current.toString());
            return;
        }

        for (Character c: keypad.get(digits.charAt(index))) {
            current.append(c);
            util(digits, current, index+1, result);
            current.deleteCharAt(current.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinationPhone().letterCombinations("23"));
    }
}
