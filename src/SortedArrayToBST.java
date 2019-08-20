import apple.laf.JRSUIUtils;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        return util(nums, 0, nums.length-1);
    }

    private TreeNode util(int[] nums, int start, int end) {

        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        int mid = (start+end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = util(nums, start, mid-1);
        node.right = util(nums, mid+1, end);

        return node;
    }
}
