package _tree._binary_tree._530;

/**
 * @Description: 530. 二叉搜索树的最小绝对差
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * @Date: 2021/3/26
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

    private int pre = -1;
    private int abs = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inOrderRecur(root);
        return abs;
    }

    //    中序遍历
    private void inOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        if (pre == -1) {
            pre = head.val;
        } else {
            abs = Math.min(abs, Math.abs(pre - head.val));
            pre = head.val;
        }
        inOrderRecur(head.right);
    }
}
