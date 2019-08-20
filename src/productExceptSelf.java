public class productExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int[]  output = new int[nums.length];

        if (nums.length == 0) {
            return output;
        }
        int leftProduct = 1;
        for (int i=0; i< nums.length; i++) {
            leftProduct *= nums[i];
            output[i] = leftProduct;
        }
        int rightProduct = 1;
        for (int i = nums.length-1; i > 0; i--) {
            output[i] = output[i-1] * rightProduct;
            rightProduct *= nums[i];
        }
        output[0] = rightProduct;

        return output;
    }

}
/*

[1,2,3,4]

[1,2,6,24]

rp = 1
[1,2,6,24]
[24,12,8,6]
 */