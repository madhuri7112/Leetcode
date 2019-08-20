public class RangeAddition {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];

        for (int op = 0; op < updates.length; op++) {
            int startIndex = updates[op][0];
            int endIndex = updates[op][1];
            int inc = updates[op][2];

            result[startIndex] += inc;
            if (endIndex < length-1) {
                result[endIndex+1] -= inc;
            }
        }
        int sum = 0;

        for (int i=0; i<result.length; i++) {
            sum += result[i];
            result[i] = sum;
        }
        return result;
    }
}
