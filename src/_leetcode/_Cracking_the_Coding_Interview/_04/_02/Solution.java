package _leetcode._Cracking_the_Coding_Interview._04._02;

import java.util.Arrays;

/**
 * @Description: 面试题 04.02. 最小高度树
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * @Author: matreeix
 * @Date: 2020/7/31
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


    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0 || nums == null) return null;
        int n = nums.length;
        if (n == 1) return new TreeNode(nums[0]);
        int val = nums[n / 2];
        TreeNode root = new TreeNode(val);
        int[] l = Arrays.copyOfRange(nums, 0, n / 2);
        int[] r = Arrays.copyOfRange(nums, n / 2 + 1, n);
        root.left = sortedArrayToBST(l);
        root.right = sortedArrayToBST(r);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        TreeNode root = sortedArrayToBST(nums);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);

        System.out.println(root.left.left.val);
        System.out.println(root.left.right);
        System.out.println(root.right.left.val);
        System.out.println(root.right.right);
    }
}
