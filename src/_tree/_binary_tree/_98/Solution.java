package _tree._binary_tree._98;

import java.util.Stack;

/**
 * @Description: 二分搜索树的判定
 * @Author: caffebaby
 * @Date: 2020/3/22
 */
public class Solution {

    //非递归
    public static boolean isValidBST(TreeNode root) {
        long pre = -2147483649L;
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    if (root.val <= pre) {//后继节点小就返回false
                        return false;
                    } else {
                        pre = root.val;
                    }
                    root = root.right;
                }
            }

        }
        return true;
    }

    //递归
    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(1);
        treeNode.right.left = new TreeNode(10);
        treeNode.right.right = new TreeNode(9);
        System.out.println(isValidBST(treeNode));
        System.out.println(Integer.MIN_VALUE > -2147483649L);

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
