package _tree._binary_tree._654;

/**
 * @Description: 654. 最大二叉树
 * 给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
 * 二叉树的根是数组 nums 中的最大元素。
 * 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
 * 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
 * 返回有给定数组 nums 构建的 最大二叉树 。
 * @Created by: matreeix
 * @Date: 2021/6/12
 */
public class Solution {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int l, int r) {
        if (l > r) return null;
        int idx = getMax(nums, l, r);
        TreeNode root = new TreeNode(nums[idx]);
        root.left = buildTree(nums, l, idx - 1);
        root.right = buildTree(nums, idx + 1, r);
        return root;
    }

    //找出数组[l,r]间的最大值的索引
    private int getMax(int[] nums, int l, int r) {
        int idx = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] > nums[idx]) {
                idx = i;
            }
        }
        return idx;
    }

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
}
