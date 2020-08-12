package _Cracking_the_Coding_Interview._04._10;

/**
 * @Description: 面试题 04.10. 检查子树
 * 检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
 * 如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
 * @Author: matreeix
 * @Date: 2020/8/4
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

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        if (t1 == null) return false;
        if (t1.val == t2.val)
            return checkSubTree(t1.left, t2.left) && checkSubTree(t1.right, t2.right);
        else
            return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = null;
        t1.right = null;
        TreeNode t2 = new TreeNode(1);
        t2.left = null;
        t2.right = null;

        System.out.println((new Solution()).checkSubTree(t1, t2));
    }
}
