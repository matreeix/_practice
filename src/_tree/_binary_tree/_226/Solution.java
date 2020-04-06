package _tree._binary_tree._226;

/**
 * @Description: 翻转二叉树
 * @Author: 67ng
 * @Date: 2020/4/2
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

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = root.right;//需要暂存右子树
        root.right = invertTree(root.left);
        root.left = invertTree(temp);

        return root;
    }

}
