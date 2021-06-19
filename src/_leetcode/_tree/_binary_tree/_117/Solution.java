package _leetcode._tree._binary_tree._117;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 117. 填充每个节点的下一个右侧节点指针 II
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 * @Date: 2021/4/4
 */

public class Solution {
    //O(n)
    public Node connect(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) node.next = queue.peek();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return root;
    }

    //O(1)
    public Node connect2(Node root) {
        Node first = root;
        Node dummy = new Node(0);
        Node pre = dummy;
        while (first != null) {
            while (first != null) {
                if (first.left != null) {
                    pre.next = first.left;
                    pre = pre.next;
                }
                if (first.right != null) {
                    pre.next = first.right;
                    pre = pre.next;
                }
                first = first.next;
            }
            first = dummy.next;
            dummy.next = null;
            pre = dummy;
        }
        return root;
    }


    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
