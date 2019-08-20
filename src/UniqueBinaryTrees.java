import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UniqueBinaryTrees {
    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] result = new int[n+1];
        Arrays.fill(result, -1);
        result[0] = 1;
        result[1] = 1;
        util(n, result);
        return result[n];
    }

    private int util(int n, int[] result) {
        if (result[n] != -1) {
            return result[n];
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            count += util(i, result) * util(n-i-1, result);
        }
        result[n] = count;

        return count;
    }
}
