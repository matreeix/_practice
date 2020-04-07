package _tree._binary_tree._563;

/**
 * @description ：得到二叉树的坡度
 * @date ： 2020-04-07
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

    public int findTilt(TreeNode root) {
        if (root==null)
            return 0;
        int left = findTilt(root.left);
        int right = findTilt(root.right);
        return left+right+Math.abs(sum(root.left)-sum(root.right));
    }

    private int sum(TreeNode root){
        if (root==null)
            return 0;

        return root.val+sum(root.left)+sum(root.right);

    }

}
