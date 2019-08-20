import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FactorCombinations {

    List<List<Integer>> factors = new ArrayList<>();
    public List<List<Integer>> getFactors(int n) {
        generatefactors(n, 2, new ArrayList<>());
        factors.remove(new ArrayList<>(Arrays.asList(n)));
        return factors;
    }

    private void generatefactors(int n, int start, List<Integer> currentFactors) {
        if (n == 1) {
            factors.add(new ArrayList<>(currentFactors));
            return;
        }

        for (int i = start; i <= n; i++) {
            if (n%i != 0) continue;
            currentFactors.add(i);
            generatefactors(n/i, i, currentFactors);
            currentFactors.remove(currentFactors.indexOf(i));
        }

    }

    public static void main(String[] args) {
        System.out.println(new FactorCombinations().getFactors(12));
    }
}
