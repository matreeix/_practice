package _Cracking_the_Coding_Interview._04._05;

/**
 * @Description: 面试题 04.05. 合法二叉搜索树
 * 实现一个函数，检查一棵二叉树是否为二叉搜索树。
 * @Author: Pythagodzilla
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

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBST(root.left)
                && isValidBST(root.right)
                && getRight(root.left) <= root.val
                && getLeft(root.right) >= root.val;
    }

    //找左子树最大值
    private long getRight(TreeNode root) {
        if (root == null) return Long.MIN_VALUE;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    //找右子树最小值
    private long getLeft(TreeNode root) {
        if (root == null) return Long.MAX_VALUE;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        return root == null ||
                (root.val > min && root.val < max && isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max));
    }


}
