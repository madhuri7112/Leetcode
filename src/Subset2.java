import java.util.ArrayList;
import java.util.List;

public class Subset2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        return result;
    }

    private void util(int[] nums, List<List<Integer>> result, boolean[] visited, int index, List<Integer> currentList) {

        result.add(new ArrayList<>(currentList));
        for (int i = index; i< nums.length; i++) {
            currentList.add(nums[i]);
            util(nums, result, visited, i+1, currentList);
            currentList.remove(currentList.size()-1);
        }
    }
}
