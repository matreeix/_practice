package _tree._binary_tree._538;

/**
 * @Description: 给定二叉搜索树（BST），
 * 将其转换为更大的树，即将原BST的每个val更改为原val加上大于BST中原val的所有val的总和。
 *
 * @Author: 67ng
 * @Date: 2020/3/25
 */
public class Solution {

    private int count = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;
        convertBST(root.right);
        count += root.val;
        root.val = count;
        convertBST(root.left);
        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


}
