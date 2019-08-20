import java.util.HashMap;

public class ContiniousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        int[] sumArray = new int[nums.length];
        int sum = 0;
        for (int i=0; i< nums.length; i++) {
            sum += nums[i];
            sumArray[i] = sum;
        }
        if (k == 0) {
            if (nums.length < 2) {
                return false;
            }

            for (int i=1; i<nums.length; i++) {
                if (sumArray[i] == 0 && sumArray[i] == sumArray[i-1]) {
                    return true;
                }
            }

            return false;
        }
        HashMap<Integer, Integer> sumModKFrequency = new HashMap<>();
        sumModKFrequency.put(0,1);

        for (int num: sumArray) {
            if (sumModKFrequency.containsKey(num%k)) {
                return true;
            }
            sumModKFrequency.put(num%k, sumModKFrequency.getOrDefault(num%k, 0)+1);
        }

        return false;
    }
}
/*
*  k= 4
*  13 - 9 = 4
* */