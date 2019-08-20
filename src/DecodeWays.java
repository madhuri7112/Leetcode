public class DecodeWays {
    public int numDecodings(String s) {
       int[] countDecodings = new int[s.length()];

       if (s.length() == 0) {
           return 0;
       }
       for (int i=0; i<countDecodings.length; i++) {
           countDecodings[i] = -1;
       }

       return numDecodingsUtil(s, 0, countDecodings);
    }

    private int numDecodingsUtil(String s, int start, int[] countDecodings) {

        if (start > s.length()-1) {
            return 1;
        }

        if (countDecodings[start] != -1) {
            return countDecodings[start];
        }

        int count = 0;

        if (isValidSingleDigit(s, start)) {
            count += numDecodingsUtil(s, start+1, countDecodings);
        }

        if (isValidTwoDigitString(s, start)) {
            count += numDecodingsUtil(s, start+2, countDecodings);
        }

        countDecodings[start] = count;

        return count;
    }

    private boolean isValidSingleDigit(String s, int start) {
        return Character.getNumericValue(s.charAt(start)) > 0 ;
    }

    private boolean isValidTwoDigitString(String s, int start) {
        return start <= s.length()-2
                && Integer.parseInt(s.substring(start, start+2)) <= 26
                && Integer.parseInt(s.substring(start, start+2)) >= 10 ;
    }

    public static void main(String[] args) {
        //System.out.println("Fd");
        System.out.println(new DecodeWays().numDecodings("123"));
    }
}
