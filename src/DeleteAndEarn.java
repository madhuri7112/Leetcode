import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> frequency = new HashMap<>();

        for (int num: nums) {
            frequency.put(num, frequency.getOrDefault(num, 0)+1);
        }

        ArrayList<Integer> uniqueNums = new ArrayList(frequency.keySet());
        Collections.sort(uniqueNums);

        return 1;
    }


}
