import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();
        for (int num: nums) {
            numsList.add(num);
        }
        generatePermutations(new ArrayList<>(), numsList, result);
        return result;
    }

    private void generatePermutations(List<Integer> currentList, List<Integer> nums, List<List<Integer>> result) {
        if (nums.isEmpty()) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int num: nums) {
            currentList.add(num);
            List<Integer> tempNums = new ArrayList<>(nums);
            tempNums.remove(nums.indexOf(num));
            generatePermutations(currentList, tempNums, result);
            currentList.remove(currentList.indexOf(num));
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Permutations().permute(nums));
    }
}
