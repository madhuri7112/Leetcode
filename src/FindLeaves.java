import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> leaves = new ArrayList<>();
        if (root == null) {
            return leaves;
        }
        findHeightOfNode(root, leaves);
        return leaves;
    }

    private int findHeightOfNode(TreeNode node, List<List<Integer>> leaves) {
        if (node == null) {
            return -1;
        }
        int height = 0;
        height = Math.max(findHeightOfNode(node.left, leaves), findHeightOfNode(node.right, leaves)) + 1;
        if (height > leaves.size() - 1) {
            leaves.add(new ArrayList<>());
        }
        leaves.get(height).add(node.val);

        return height;

    }
}