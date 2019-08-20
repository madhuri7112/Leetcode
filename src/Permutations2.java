import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> allNums = new ArrayList<>();

        for (int num: nums) {
            allNums.add(num);
        }
        util(allNums, result, new ArrayList<>());

        return result;
    }

    private void util(List<Integer> nums, List<List<Integer>> result, List<Integer> currentList) {
        if (nums.isEmpty()) {
            result.add(new ArrayList<>(currentList));
        }
        for (int i = 0; i < nums.size(); i++) {
            if (i!=0 && nums.get(i) == nums.get(i-1)) {
                continue;
            }
            currentList.add(nums.get(i));
            List<Integer> remNums = new ArrayList<>(nums);
            remNums.remove(i);
            util(remNums, result, currentList);
            currentList.remove(currentList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3};
        System.out.println(new Permutations2().permuteUnique(nums));
    }
}
