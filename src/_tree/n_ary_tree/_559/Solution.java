package _tree.n_ary_tree._559;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: n叉树的最大深度
 * @Author: caffebaby
 * @Date: 2020/4/2
 */
public class Solution {
    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        int count = 0;
        if (root.children != null)
            for (Node node : root.children)
                count = Math.max(count, maxDepth(node));
        return count + 1;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);

        List<Node> children1 = new ArrayList<>();
        children1.add(node1);
        children1.add(node2);
        children1.add(node3);
        node.children = children1;

        List<Node> children2 = new ArrayList<>();
        children2.add(node4);
        children2.add(node5);
        node1.children = children2;
//
//        List<Node> children3 = new ArrayList<>();
//        children3.add(node6);
//        node5.children = children3;

        System.out.println((new Solution()).maxDepth(node));

    }

}
