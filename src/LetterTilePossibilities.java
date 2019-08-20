public class LetterTilePossibilities {
    int count = 0;
    public int numTilePossibilities(String tiles) {
      numSubsets(tiles, 0, new StringBuffer());
      return count;
    }

    private void numSubsets(String str, int start, StringBuffer currentSubstring) {
        System.out.println(currentSubstring.toString());
        if (currentSubstring.length() == str.length()) return;
        count = count+1;

        for (int i = 0; i< str.length(); i++) {
            currentSubstring.append(str.charAt(i));
            numSubsets(str, i+1, currentSubstring);
            currentSubstring.deleteCharAt(currentSubstring.length()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterTilePossibilities().numTilePossibilities("ABC"));;
    }
}

