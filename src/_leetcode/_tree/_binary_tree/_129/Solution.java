package _leetcode._tree._binary_tree._129;

/**
 * @Description: 129. 求根节点到叶节点数字之和
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * <p>
 * 叶节点 是指没有子节点的节点。
 * @Date: 2021/4/5
 */

public class Solution {

    private int sum;

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode node, int cnt) {
        if (node.left == null && node.right == null) {
            sum += cnt * 10 + node.val;
            return;
        }
        cnt = cnt * 10 + node.val;
        if (node.left != null)
            dfs(node.left, cnt);
        if (node.right != null)
            dfs(node.right, cnt);
    }

    public int sumNumbers2(TreeNode root) {
        return dfs2(root, 0);
    }

    public int dfs2(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return dfs2(root.left, sum) + dfs2(root.right, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println((new Solution()).sumNumbers(root));
    }


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
}
