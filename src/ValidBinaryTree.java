public class ValidBinaryTree {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        return util(root.left, root.val, null) && util(root.right, null, root.val);
    }

    private boolean util(TreeNode root, Integer max, Integer min) {
        if (root == null) {
            return true;
        }

        if ((min!=null && root.val <= min) || (max!=null && root.val >= max)) {
            return false;
        }

        return util(root.left, root.val, min) && util(root.right, max, root.val);
    }
}
