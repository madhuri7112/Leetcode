import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TreeBoundary {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> boundary = new ArrayList<>();

        if (root == null) {
            return boundary;
        }
        boundary.add(root.val);
        if (isLeaf(root)) {
            return boundary;
        }
        boundary.addAll(findLeftBoundary(root.left));
        boundary.addAll(findLeaves(root));
        List<Integer> rightBoundary = findRightBoundary(root.right);
        Collections.reverse(rightBoundary);
        boundary.addAll(rightBoundary);

        return boundary;
    }

    private List<Integer> findLeftBoundary(TreeNode root) {
        List<Integer> boundary = new ArrayList<>();
        if (root == null) {
            return boundary;
        }
        if (!isLeaf(root))
            boundary.add(root.val);
        if (root.left != null) {
            boundary.addAll(findLeftBoundary(root.left));
        } else {
            boundary.addAll(findLeftBoundary(root.right));
        }

        return boundary;
    }

    private List<Integer> findRightBoundary(TreeNode root) {
        List<Integer> boundary = new ArrayList<>();
        if (root == null) {
            return boundary;
        }
        if (!isLeaf(root))
            boundary.add(root.val);
        if (root.right != null) {
            boundary.addAll(findRightBoundary(root.right));
        } else {
            boundary.addAll(findRightBoundary(root.left));
        }

        return boundary;
    }

    private List<Integer> findLeaves(TreeNode root) {
        List<Integer> leaves = new ArrayList<>();
        if (root == null) {
            return leaves;
        }
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return leaves;
        }
        List<Integer> subTreeLeaves = findLeaves(root.left);
        subTreeLeaves.addAll(findLeaves(root.right));

        return subTreeLeaves;
    }

    private boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }
        return node.left == null && node.right == null;
    }
}
