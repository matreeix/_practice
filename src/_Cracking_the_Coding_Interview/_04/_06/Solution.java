package _Cracking_the_Coding_Interview._04._06;

/**
 * @Description: 面试题 04.06. 后继者
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * 如果指定节点没有对应的“下一个”节点，则返回null
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

    //迭代法
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {//p的后继节点即是其右子树的最左节点
            p = p.right;
            while (p.left != null)
                p = p.left;
            return p;
        } else {//p的后继节点即是让p在其左子树上的最近祖先节点
            TreeNode successor = null;
            while (root != p) {
                if (root.val > p.val) {
                    successor = root;
                    root = root.left;
                } else if (root.val < p.val) {
                    root = root.right;
                }
            }
            return successor;
        }
    }

    //递归
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        if (root.val <= p.val)
            return inorderSuccessor2(root.right, p);
        else
            return inorderSuccessor(root.left, p) == null ? root : inorderSuccessor(root.left, p);
    }

    public static void main(String[] args) {

    }

}
