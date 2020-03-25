package _tree._binary_tree._110;

/**
 * @Description:
 * @Author: 67ng
 * @Date: 2020/3/24
 */
public class Solution {

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int left = depth(root.left);
        int right = depth(root.right);
        return Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    //求树的深度
    private int depth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }


    //Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
