package _tree._binary_tree._1325;

import java.util.Stack;

/**
 * @Description: 刪除給定值的叶子节点
 * <p>
 * 给你一棵以 root 为根的二叉树和一个整数 target ，请你删除所有值为 target 的 叶子节点 。
 * 注意，一旦删除值为 target 的叶子节点，它的父节点就可能变成叶子节点；如果新叶子节点的值恰好也是 target ，那么这个节点也应该被删除。
 * 也就是说，你需要重复此过程直到不能继续删除。
 * @Author: Pythagodzilla
 * @Date: 2020/7/9
 */

public class Solution {
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

    //nice solution!
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root.left != null)
            root.left = removeLeafNodes(root.left, target);
        if (root.right != null)
            root.right = removeLeafNodes(root.right, target);
        return root.left == root.right && root.val == target ? null : root;
    }

    public static void main(String[] args) {

    }
}
