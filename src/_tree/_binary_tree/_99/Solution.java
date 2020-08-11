package _tree._binary_tree._99;

/**
 * @Description: BST中有两个元素位置错误，在不改变其结构的情况下将其复原
 * @Author: caffebaby
 * @Date: 2020/3/23
 */
public class Solution {
    //记录错误的俩节点
    TreeNode firstElement = null;
    TreeNode secondElement = null;

    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);//记录前置节点

    public void recoverTree(TreeNode root) {

        //中序遍历找到错误的俩节点
        traverse(root);

        //交换错误的俩节点的值
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private void traverse(TreeNode root) {

        if (root == null)
            return;

        traverse(root.left);

        //找到第一个错误的节点
        if (firstElement == null && prevElement.val >= root.val) {
            firstElement = prevElement;
        }

        //找到第二个错误的节点，注意赋值的位置
        if (firstElement != null && prevElement.val >= root.val) {
            secondElement = root;
        }
        prevElement = root;//遍历节点


        traverse(root.right);
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
