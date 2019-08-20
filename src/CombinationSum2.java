import java.util.ArrayList;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        util(candidates, target, new ArrayList<>(), result, 0);
        return result;
    }

    private void util(int[] candidates, int target,  List<Integer> currentList, List<List<Integer>> result, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        if (target <0) {
            return;
        }

        for (int i = start; i<candidates.length; i++) {
            currentList.add(candidates[i]);
            util(candidates, target-candidates[i], currentList, result, i+1);
            currentList.remove(currentList.size()-1);
        }
    }
}
