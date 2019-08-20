import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> candidateSet = new HashSet<Integer>();
        Arrays.sort(candidates);
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
            if (i != start && candidates[i] == candidates[i-1]) continue;
            currentList.add(candidates[i]);
            util(candidates, target-candidates[i], currentList, result, i+1);
            currentList.remove(currentList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        System.out.println(new CombinationSum().combinationSum2(candidates, 7));
    }
}
