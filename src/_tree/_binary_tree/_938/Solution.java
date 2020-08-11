package _tree._binary_tree._938;

/**
 * @Description: 找到指定范围内BST节点值之和
 * @Author: caffebaby
 * @Date: 2020/3/25
 */
public class Solution {
    private static int sum = 0;

    public static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null)
            return 0;
        rangeSumBST(root.left, L, R);
        if (root.val >= L && root.val <= R)
            sum += root.val;
        rangeSumBST(root.right, L, R);
        return sum;
    }

    public int rangeSumBST2(TreeNode root, int L, int R) {
        if (root == null) return 0; // base case.
        return (L <= root.val && root.val <= R ? root.val : 0) + rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);
        System.out.println(rangeSumBST(root, 7, 15));
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
