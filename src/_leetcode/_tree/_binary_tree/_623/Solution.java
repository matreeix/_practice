package _leetcode._tree._binary_tree._623;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 在二叉树中增加一行
 * @Author: matreeix
 * @Date: 2020/6/1
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

    public TreeNode addOneRow(TreeNode t, int v, int d) {
        if (d == 1) {
            TreeNode n = new TreeNode(v);
            n.left = t;
            return n;
        }
        insert(t, v, 1, d);
        return t;
    }

    //前序深度优先遍历插入
    public void insert(TreeNode node, int val, int depth, int n) {
        if (node == null)
            return;
        if (depth == n - 1) {
            TreeNode t = node.left;
            node.left = new TreeNode(val);
            node.left.left = t;
            t = node.right;
            node.right = new TreeNode(val);
            node.right.right = t;
        } else {
            insert(node.left, val, depth + 1, n);
            insert(node.right, val, depth + 1, n);
        }
    }

    //广度优先遍历
    public TreeNode addOneRow2(TreeNode t, int v, int d) {
        if (d == 1) {
            TreeNode n = new TreeNode(v);
            n.left = t;
            return n;
        }
        Queue< TreeNode > queue = new LinkedList< >();
        queue.add(t);
        int depth = 1;
        while (depth < d - 1) {
            Queue < TreeNode > temp = new LinkedList < > ();
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                if (node.left != null) temp.add(node.left);
                if (node.right != null) temp.add(node.right);
            }
            queue = temp;
            depth++;
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            TreeNode temp = node.left;
            node.left = new TreeNode(v);
            node.left.left = temp;
            temp = node.right;
            node.right = new TreeNode(v);
            node.right.right = temp;
        }
        return t;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);
        TreeNode res = (new Solution()).addOneRow(root, 1, 2);
        System.out.println(res.val);
        System.out.print(res.left.val + " ");
        System.out.println(res.right.val);
        System.out.print(res.left.left.val + " ");
        System.out.println(res.right.right.val);
        System.out.print(res.left.left.left.val + " ");
        System.out.print(res.left.left.right.val + " ");
        System.out.println(res.right.right.left.val);

    }

}
