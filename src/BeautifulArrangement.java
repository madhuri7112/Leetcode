import java.util.ArrayList;
import java.util.List;

public class BeautifulArrangement {
    int totalCount = 0;
    public int countArrangement(int N) {
        List<Integer> allNums = new ArrayList<>();
        for (int i=1; i<=N; i++) {
            allNums.add(i);
        }

        permute(allNums, new ArrayList<>());

        return totalCount;
    }

    private void permute(List<Integer> allNums, List<Integer> currentList) {

        if (allNums.size() == 0) {
            if (validArrangement(currentList)) {
                totalCount++;
            }
            return;
        }
        for (int num: allNums) {
            int size = currentList.size();
            if (num%(size+1) != 0 && (size+1)%num != 0) continue;
            currentList.add(num);
            List<Integer> remNums = new ArrayList<>(allNums);
            remNums.remove(remNums.indexOf(num));
            permute(remNums, currentList);
            currentList.remove(currentList.size()-1);
        }
    }

    private boolean validArrangement(List<Integer> list) {
        for (int i=0; i< list.size(); i++) {
            if (list.get(i)%(i+1) != 0 && (i+1)%list.get(i) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new BeautifulArrangement().countArrangement(6));
    }
}
