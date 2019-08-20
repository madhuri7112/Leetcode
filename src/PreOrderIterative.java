import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderIterative {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> order = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        while (current!=null || !stack.isEmpty()) {

            while (current != null) {
                order.add(current.val);
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            current = current.right;

        }

        return order;
    }
}
