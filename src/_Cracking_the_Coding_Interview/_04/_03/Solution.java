package _Cracking_the_Coding_Interview._04._03;

import java.util.*;

/**
 * @Description: 面试题 04.03. 特定深度节点链表
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表
 * （比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 * @Author: caffebaby
 * @Date: 2020/7/31
 */

public class Solution {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static ListNode[] listOfDepth(TreeNode tree) {
        List<ListNode> levels = new ArrayList<>();
        if (tree == null) return new ListNode[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        int level = 0;
        while (!queue.isEmpty()) {
            levels.add(new ListNode(-1));
            ListNode tmp = levels.get(level);
            int level_length = queue.size();
            for (int i = 0; i < level_length; ++i) {
                TreeNode node = queue.remove();
                tmp.next = new ListNode(node.val);
                tmp = tmp.next;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            level++;
        }

        ListNode[] res = new ListNode[levels.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = levels.get(i).next;
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);

        ListNode[] res = listOfDepth(root);
        for (ListNode listNode : res) {
            while (listNode != null) {
                System.out.print(listNode.val+"->");
                listNode = listNode.next;
            }
            System.out.println();
        }
    }
}
