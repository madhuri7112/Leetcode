import java.util.ArrayList;
import java.util.Arrays;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2) {
            return intervals;
        }

        //int[][] sortedIntervals = new int[intervals.length][2];
        ArrayList<int[]> sortedIntervals = new ArrayList<>();
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int[] currentInterval = intervals[0];
        for (int[] interval : intervals) {
            if (interval[0] > currentInterval[1]) {
                currentInterval = interval;
                sortedIntervals.add(currentInterval);
                continue;
            }
            if (sortedIntervals.size() !=0 ) {
                sortedIntervals.remove(sortedIntervals.size()-1);
            }

            currentInterval[1] = Math.max(currentInterval[1], interval[1]);
            sortedIntervals.add(currentInterval);
        }

        int[][] result = new int[sortedIntervals.size()][2];

        for (int i=0; i< result.length; i++) {
            result[i] = sortedIntervals.get(i);
        }

        return result;
    }
}
