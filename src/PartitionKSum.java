import java.util.Arrays;
import java.util.List;

public class PartitionKSum {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Arrays.sort(nums);
        return true;
    }

    private boolean util(int[] nums, boolean[] visited, int k, List<Integer> currentSubset) {
        for (int i= 0; i < nums.length; i++) {
            if (visited[i]) continue;

        }

        return false;
    }
}
