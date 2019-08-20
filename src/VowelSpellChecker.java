import java.util.HashMap;
import java.util.HashSet;

public class VowelSpellChecker {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        HashSet<String> allWords = new HashSet<>();
        HashMap<String, String> lowerCased = new HashMap<>();
        HashMap<String, String> vowelsMasked = new HashMap<>();

        for (String word: wordlist) {
            allWords.add(word);

            lowerCased.putIfAbsent(word.toLowerCase(), word);

            vowelsMasked.putIfAbsent(devowel(word.toLowerCase()), word);
        }

        String[] result = new String[queries.length];

        for (int i=0; i< queries.length; i++) {
            String qWord = queries[i];
            if (allWords.contains(qWord)) {
                result[i] = qWord;
                continue;
            }

            if (lowerCased.containsKey(qWord.toLowerCase())) {
                result[i] = lowerCased.get(qWord.toLowerCase());
                continue;
            }

            if (vowelsMasked.containsKey(devowel(qWord.toLowerCase()))) {
                result[i] = vowelsMasked.get(devowel(qWord));
                continue;
            }

            result[i] = "";
        }

        return result;
    }

    public String devowel(String word) {
        word = word.toLowerCase();
        StringBuilder ans = new StringBuilder();
        for (char c: word.toCharArray())
            ans.append(isVowel(c) ? '*' : c);
        return ans.toString();
    }

    public boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }
}
