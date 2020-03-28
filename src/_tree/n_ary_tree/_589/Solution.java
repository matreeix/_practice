package _tree.n_ary_tree._589;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: n叉树的前序遍历
 * @Author: 67ng
 * @Date: 2020/3/28
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

    private List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null)
            return new ArrayList<>();
        list.add(root.val);
        if (root.children != null)
            for (Node node : root.children)
                preorder(node);

        return list;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);

        List<Node> children1 = new ArrayList<>();
        children1.add(node1);
        children1.add(node2);
        children1.add(node3);
        node.children = children1;

        List<Node> children2 = new ArrayList<>();
        children2.add(node4);
        children2.add(node5);
        node1.children = children2;

        System.out.println((new Solution()).preorder(node));

    }

}
