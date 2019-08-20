import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BeautifulArrangement2 {

    List<Integer> result = new ArrayList<>();
    public int[] constructArray(int n, int k) {
        int[] resultArray = new int[n];
        List<Integer> allNums = new ArrayList<>();
        for (int i=1;i<=n;i++) {
            allNums.add(i);
        }
        permute(allNums, new ArrayList<>(), new HashSet<>(), k);
        for (int i=0; i<n;i++) {
            resultArray[i] = result.get(i);
        }
        System.out.println(result);
        return resultArray;
    }


    private boolean permute(List<Integer> numbers, List<Integer> currentList, HashSet<Integer> differences, int k) {
        if (numbers.size() == 0) {
            if (differences.size() == k) {
                result = new ArrayList<>(currentList);
                System.out.println(currentList);
                System.out.println(differences);
                return true;
            }
            return false;
        }

        for (int num: numbers) {

            if (currentList.size() != 0) {
                int diff = Math.abs(currentList.get(currentList.size()-1) - num);
                differences.add(diff);
            }
            if (differences.size()>k) {
                continue;
            }

            currentList.add(num);
            List<Integer> remNums = new ArrayList<>(numbers);
            remNums.remove(remNums.indexOf(num));
            if (permute(remNums, currentList, differences, k)) {
                return true;
            }
            currentList.remove(new Integer(num));

        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new BeautifulArrangement2().constructArray(5,4));
    }
}
