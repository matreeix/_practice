package _tree._binary_tree._671;

/**
 * @Description: 找出符合下面条件的二叉树的第二小值，没有则返回-1
 * <p>
 * 1.每个节点有0个或2个左右子节点
 * 2.root.val = min(root.left.val, root.right.val)
 * 3.节点的值为非负整数
 *
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

    public static int findSecondMinimumValue(TreeNode root) {
        if(root.left == null) return -1;

        int l = root.left.val == root.val ? findSecondMinimumValue(root.left) : root.left.val;
        int r = root.right.val == root.val ? findSecondMinimumValue(root.right) : root.right.val;

        return l == -1 || r == -1 ? Math.max(l, r) : Math.min(l, r);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println(findSecondMinimumValue(root));
    }
}
