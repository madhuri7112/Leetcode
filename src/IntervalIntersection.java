import java.util.ArrayList;

public class IntervalIntersection {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int pointerA = 0, pointerB = 0;
        ArrayList<int[]> intersection = new ArrayList<>();
        while (pointerA < A.length && pointerB < B.length) {
            if (A[pointerA][1] < B[pointerB][0]) {
                pointerA++;
                continue;
            }
            if (B[pointerB][1] < A[pointerA][0]) {
                pointerB++;
                continue;
            }
            int[] common = new int[2];
            common[0] = Math.max(A[pointerA][0], B[pointerB][0]);
            common[1] = Math.min(A[pointerA][1], B[pointerB][1]);
            intersection.add(common);
            if (A[pointerA][1] <  B[pointerB][1]) {
                pointerA++;
            } else {
                pointerB++;
            }

        }
        int[][] result = new int[intersection.size()][2];
        intersection.toArray(result);

        return result;
    }
}
