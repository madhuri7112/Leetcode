import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ZigzagTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean reverseFlag = false;
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
                if (reverseFlag) {
                    level.add(0, next.val);
                } else {
                    level.add(next.val);
                }

                if (next.left != null) {
                    children.add(next.left);
                }
                if (next.right != null) {
                    children.add(next.right);
                }
            }

            levels.add(level);
            reverseFlag = !reverseFlag;
            current = children;
            children = new ArrayList<>();
        }


        return levels;
    }
}
