package _leetcode._tree._binary_tree._124;

/**
 * @Description: 124. 二叉树中的最大路径和
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * @Date: 2021/9/16
 */

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        singlePathMax(root);
        return maxPath;
    }

    private int singlePathMax(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(singlePathMax(node.left), 0);
        int right = Math.max(singlePathMax(node.right), 0);

        maxPath = Math.max(maxPath, node.val + left + right);

        return node.val + Math.max(left, right);
    }


}
