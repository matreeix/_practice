package _tree._binary_tree._450;

/**
 * @Description: 450. 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 一般来说，删除节点可分为两个步骤：
 * 1.首先找到需要删除的节点；
 * 2.如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 * @Created by: matreeix
 * @Date: 2021/5/28
 */
public class Solution {
    public class TreeNode {
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

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val != key) {
            root.left = deleteNode(root.left, key);
            root.right = deleteNode(root.right, key);
            return root;
        } else {
            TreeNode left = deleteNode(root.left, key);
            TreeNode right = deleteNode(root.right, key);
            if (right == null) return left;
            TreeNode tmp = right;
            while (tmp.left != null) {
                tmp = tmp.left;
            }
            tmp.left = left;
            return right;
        }

    }
}
