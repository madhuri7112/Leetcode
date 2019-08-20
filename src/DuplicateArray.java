import java.util.*;

import static java.lang.Math.abs;

public class DuplicateArray {
    public List<Integer> findDuplicates(int[] nums) {
        for (int num: nums) {
           nums[abs(num)-1] = -1* nums[abs(num)-1];
        }

        Set<Integer> outputSet = new HashSet<Integer>();
        //List<Integer> output = new LinkedList<>();
        for (int num: nums) {
            if (nums[abs(num)-1] >= 0) {
                outputSet.add(Math.abs(num));
            }
        }

        return new ArrayList<>(outputSet);
    }
}




