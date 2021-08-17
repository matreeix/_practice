package _leetcode._design._1261;

import java.util.LinkedList;

/**
 * @Description:
 * @Date: 2021/8/17
 */

public class FindElements2 {

    private LinkedList<Integer> tmp;
    private TreeNode ROOT;

    public FindElements2(TreeNode root) {
        tmp = new LinkedList<>();
        root.val = 0;
        ROOT = root;
        dfs(root);
    }

    public void dfs(TreeNode node) {
        if (node == null) return;
        int x = node.val;
        if (node.left != null) node.left.val = 2 * x + 1;
        if (node.right != null) node.right.val = 2 * x + 2;
        dfs(node.left);
        dfs(node.right);
    }

    public boolean find(int target) {
        if (target == 0) return true;
        while (target != 0) {
            tmp.addFirst(target);
            if (target % 2 == 0) {
                target = (target - 2) / 2;
            } else {
                target = (target - 1) / 2;
            }
        }
        TreeNode node = ROOT;
        for (int n : tmp) {
            if (node.left != null && node.left.val == n) {
                node = node.left;
            } else if (node.right != null && node.right.val == n) {
                node = node.right;
            } else {
                tmp.clear();
                return false;
            }
        }
        tmp.clear();
        return true;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
