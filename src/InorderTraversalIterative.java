import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversalIterative {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            order.add(current.val);
            current = current.right;
        }

        return order;
    }
}
