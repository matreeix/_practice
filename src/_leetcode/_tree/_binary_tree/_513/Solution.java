package _leetcode._tree._binary_tree._513;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 513. 找树左下角的值
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * 注意: 您可以假设树（即给定的根节点）不为 NULL。
 * @Date: 2021/7/1
 */

public class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int left = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            left = q.peek().val;
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
        return left;
    }

    public class TreeNode {
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
