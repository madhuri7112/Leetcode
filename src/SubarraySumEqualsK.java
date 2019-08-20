import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int[] sumArray = new int[nums.length];
        int sum = 0;
        for (int i=0; i< nums.length; i++) {
            sum += nums[i];
            sumArray[i] = sum;
        }
        HashMap<Integer, Integer> sumFrequency = new HashMap<>();
        sumFrequency.put(0,1);
        int count = 0;
        for (int num: sumArray) {
            count += sumFrequency.getOrDefault(num-k, 0);
            sumFrequency.put(num, sumFrequency.getOrDefault(num, 0)+1);
        }

        return count;
    }
}

