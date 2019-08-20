import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class levelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<TreeNode> current = new ArrayList<>();
        List<TreeNode> children = new ArrayList<>();
        List<List<Integer>> levels = new ArrayList<>();

        if (root == null) {
            return levels;
        }

        current.add(root);
        while (!current.isEmpty()) {
            Iterator<TreeNode> iterator = current.iterator();
            List<Integer>  level = new ArrayList<>();
            while (iterator.hasNext()) {
                TreeNode next = iterator.next();
                level.add(next.val);
                if (next.left != null) {
                    children.add(next.left);
                }
                if (next.right != null) {
                    children.add(next.right);
                }
            }

            levels.add(level);
            current = children;
            children = new ArrayList<>();
        }


        return levels;
    }


}
