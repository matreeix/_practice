package _leetcode._CONTEST._weekly._209;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 1609. 奇偶树
 * 如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
 * <p>
 * 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
 * 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
 * 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
 * 给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
 * @Author: matreeix
 * @Date: 2020/10/8
 */

public class Solution2 {
    static class TreeNode {
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

    public static boolean isEvenOddTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int level_length = queue.size();
            TreeNode pre = null;
            for (int i = 0; i < level_length; ++i) {
                TreeNode cur = queue.remove();
                if (level % 2 == 0) {
                    pre = pre == null ? new TreeNode(0) : pre;
                    if (cur.val % 2 == 0) return false;
                    if (cur.val <= pre.val) return false;
                } else {
                    pre = pre == null ? new TreeNode(10000000) : pre;
                    if (cur.val % 2 == 1) return false;
                    if (cur.val >= pre.val) return false;
                }

                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                pre = cur;
            }
            level++;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(12);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(9);
        root.left.left.left = new TreeNode(18);
        root.left.left.right = new TreeNode(16);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(9);
        System.out.println(isEvenOddTree(root));
    }
}


