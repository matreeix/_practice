package _leetcode._Cracking_the_Coding_Interview._04._04;

/**
 * @Description: 面试题 04.04. 检查平衡性
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 * @Author: matreeix
 * @Date: 2020/7/31
 */

public class Solution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return root == null || (isBalanced(root.left) && isBalanced(root.right) && Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1);
    }

    private int getHeight(TreeNode root) {
        return root == null ? 0 : Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

}
