package _tree._binary_tree._230;

/**
 * @Description: 找到BST树中第k小的数
 * @Author: 67ng
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
        int left = nodeCount(root.left);  // this value can be saved in the root node
        if (left + 1 == k) {
            return root.val;
        } else if (left + 1 < k) {
            return kthSmallest(root.right, k - left - 1);
        } else {
            return kthSmallest(root.left, k);
        }
    }

    private int nodeCount(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + nodeCount(root.left) + nodeCount(root.right);
    }

    public static void main(String[] args) {

    }

}
