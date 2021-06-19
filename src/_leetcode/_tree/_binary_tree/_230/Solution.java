package _leetcode._tree._binary_tree._230;

/**
 * @Description: 找到BST树中第k小的数
 * @Author: matreeix
 * @Date: 2020/3/25
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

    public int kthSmallest(TreeNode root, int k) {
        int left = nodeCount(root.left); //统计根节点左子树节点数
        if (left + 1 == k) {//第k小刚好是根节点
            return root.val;
        } else if (left + 1 < k) {//在右子树时
            return kthSmallest(root.right, k - left - 1);
        } else {//在左子树时
            return kthSmallest(root.left, k);
        }
    }

    //统计节点个数
    private int nodeCount(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + nodeCount(root.left) + nodeCount(root.right);
    }

    public static void main(String[] args) {

    }

}
