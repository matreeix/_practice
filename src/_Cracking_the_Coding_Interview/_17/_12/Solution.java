package _Cracking_the_Coding_Interview._17._12;

/**
 * @Description: 面试题 17.12. BiNode
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。
 * 实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 * 返回转换后的单向链表的头节点。
 * 注意：本题相对原题稍作改动
 * @Author: matreeix
 * @Date: 2020/12/19
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

    TreeNode head, tail;
    public TreeNode convertBiNode(TreeNode root) {
        head = new TreeNode(-1);
        tail = head;
        traverse(root);
        return head.right;
    }

    private void traverse(TreeNode root){
        if(root == null) return;
        traverse(root.left);
        root.left = null;
        tail.right = root;
        tail = tail.right;
        traverse(root.right);
    }
}
