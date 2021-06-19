package _leetcode._tree._binary_tree._236;

/**
 * @Description: 求二叉树俩节点的最近公共祖先
 * @Author: matreeix
 * @Date: 2020/3/26
 */
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归终止条件
        if (root == null //1.没找到
                || root == p //2.找到p
                || root == q) return root;//3.找到q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        //1.左子树未找到肯定在右子树，反之亦然；都没找到就是null
        //2.左右子树都找到，最近公共祖先节点就是root呗
        return left == null ? right : right == null ? left : root;
    }


    //Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
