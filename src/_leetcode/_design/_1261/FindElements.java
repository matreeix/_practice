package _leetcode._design._1261;

/**
 * @Description: 1261. 在受污染的二叉树中查找元素
 * 给出一个满足下述规则的二叉树：
 * root.val == 0
 * 如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x + 1
 * 如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x + 2
 * 现在这个二叉树受到「污染」，所有的 treeNode.val 都变成了 -1。
 *
 * 请你先还原二叉树，然后实现 FindElements 类：
 *
 * FindElements(TreeNode* root) 用受污染的二叉树初始化对象，你需要先把它还原。
 * bool find(int target) 判断目标值 target 是否存在于还原后的二叉树中并返回结果。
 * @Date: 2021/8/17
 */

public class FindElements {

    private boolean[] vals;

    public FindElements(TreeNode root) {
        vals = new boolean[1048577];
        root.val = 0;
        dfs(root);
    }

    public void dfs(TreeNode node) {
        if (node == null) return;
        int x = node.val;
        vals[x] = true;
        if (node.left != null) node.left.val = 2 * x + 1;
        if (node.right != null) node.right.val = 2 * x + 2;
        dfs(node.left);
        dfs(node.right);
    }

    public boolean find(int target) {
        return vals[target];
    }

    class TreeNode {
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
