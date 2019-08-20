public class subArrayProductLessThank {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k<=1) return 0;
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0] == k ? 1 :0 ;
        }

        int count = 0;
        int product = 1;
        int leftPointer = 0;
        for (int rightPointer = 0; rightPointer < nums.length; rightPointer++) {
            product *= nums[rightPointer];

            while (leftPointer< rightPointer && product >= k) {
                product /= nums[leftPointer];
                leftPointer ++;
            }

            count += rightPointer - leftPointer + 1;
        }
        return count;
    }
}
