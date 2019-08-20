import java.util.ArrayList;

public class DIString {
    public int[] diStringMatch(String S) {

        int max = S.length();
        int min = 0;
        int[] result = new int[S.length()];
        if (S.length() == 0){
            return result;
        }
        int i=0;
        for (char c: S.toCharArray()) {
            if (c == 'D') {
                result[i] = max;
                max --;
            } else {
                result[i]= (min);
                min++;
            }
            i++;
        }

        result[i] = min;
        return result;
    }
}
