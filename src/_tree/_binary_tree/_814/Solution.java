package _tree._binary_tree._814;

/**
 * @Description: 二叉树的剪枝
 * @Author: matreeix
 * @Date: 2020/5/6
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

    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return root;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.val == 1) {
            return root;
        } else {
            if (root.left != null || root.right != null)
                return root;
            else
                return null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(0);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        TreeNode newRoot = (new Solution()).pruneTree(root);
        System.out.println(newRoot.val);
        System.out.println(newRoot.left.val);
        System.out.println(newRoot.left.left.val);
        System.out.println(newRoot.left.right);
        System.out.println(newRoot.right.val);
        System.out.println(newRoot.right.left);
        System.out.println(newRoot.right.right.val);


    }
}
