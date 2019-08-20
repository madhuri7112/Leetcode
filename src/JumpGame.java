public class JumpGame {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        boolean[] canJump = new boolean[nums.length];

        canJump[canJump.length-1] = true;

        for (int i = canJump.length-2; i>=0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                if ( i+j >= canJump.length) {
                    break;
                }
                if (canJump[i+j]) {
                    canJump[i] = true;
                    break;
                }
            }
        }

        return canJump[0];
    }
}
