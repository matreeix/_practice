package _tree._binary_tree._103;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 103. 二叉树的锯齿形层次遍历
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * @Author: caffebaby
 * @Date: 2020/8/7
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

    /**
     * 原理：使用两个栈，两个栈弹出元素时向对方装入自己的子树，直到空为止
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Stack<TreeNode> stackL = new Stack<>();//左子节点先入栈
        Stack<TreeNode> stackR = new Stack<>();//右子节点先入栈
        stackR.push(root);

        while (stackL.size() != 0 || stackR.size() != 0) {
            List<Integer> list1 = new ArrayList<>();
            while (stackR.size() != 0) {
                TreeNode node = stackR.pop();
                list1.add(node.val);
                if (node.left != null) stackL.push(node.left);
                if (node.right != null) stackL.push(node.right);
            }
            if (list1.size() != 0)
                res.add(list1);

            List<Integer> list2 = new ArrayList<>();
            while (stackL.size() != 0) {
                TreeNode node = stackL.pop();
                list2.add(node.val);
                if (node.right != null) stackR.push(node.right);
                if (node.left != null) stackR.push(node.left);
            }
            if (list2.size() != 0)
                res.add(list2);
        }
        return res;
    }

    //dfs
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        dfsZigzagLevelOrder(ret, root, 0);
        return ret;

    }

    public void dfsZigzagLevelOrder(List<List<Integer>> ret, TreeNode root, int level) {
        if (root == null) return;
        LinkedList<Integer> list;
        if (level >= ret.size()) {
            list = new LinkedList<>();
            if (level % 2 != 0)
                list.addFirst(root.val);
            else
                list.addLast(root.val);
            ret.add(list);
        } else {
            list = (LinkedList) ret.get(level);
            if (level % 2 != 0)
                list.addFirst(root.val);
            else
                list.addLast(root.val);
        }
        dfsZigzagLevelOrder(ret, root.left, level + 1);
        dfsZigzagLevelOrder(ret, root.right, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        List<List<Integer>> res = zigzagLevelOrder(root);
        System.out.println(res);
    }
}
