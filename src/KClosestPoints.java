import java.util.*;

public class KClosestPoints {
    public int[][] kClosest(int[][] points, int K) {


        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> -1 *(p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]));

        for (int[] point : points) {
            pq.offer(point);
            pq.add(point);
        }

        ArrayList<int[]> result = new ArrayList<>();

        while (result.size() < K && !pq.isEmpty()) {
            result.add(pq.poll());
        }

        int[][] resultArray = new int[result.size()][2];
        result.toArray(resultArray);

        return resultArray;
    }
}
