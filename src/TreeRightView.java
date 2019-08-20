import apple.laf.JRSUIUtils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeRightView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightMostElements = new ArrayList<>();
        List<TreeNode> current = new ArrayList<>();
        List<TreeNode> children = new ArrayList<>();

        if (root == null) {
            return rightMostElements;
        }

        current.add(root);
        while (!current.isEmpty()) {
            rightMostElements.add(current.get(0).val);
            Iterator<TreeNode> iterator = current.iterator();
            while (iterator.hasNext()) {
                TreeNode next = iterator.next();
                if (next.right != null) {
                    children.add(next.right);
                }
                if (next.left != null) {
                    children.add(next.left);
                }
            }

            current = children;
            children = new ArrayList<>();
        }

        return rightMostElements;
    }
}
