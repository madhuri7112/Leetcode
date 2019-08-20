import java.util.ArrayList;
import java.util.List;

public class Subsets {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        generateSubsets(0, nums, new ArrayList<>());
        return result;
    }


    private void generateSubsets(int index, int[] nums, List<Integer> subset) {
        result.add(new ArrayList<Integer>(subset));
        for (int i = index; i < nums.length; i++) {
          subset.add(nums[i]);
          generateSubsets(i+1, nums, subset);
          subset.remove(subset.size()-1);
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        new Subsets().subsets(nums);
    }


}
