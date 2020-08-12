package _tree.n_ary_tree._590;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 后序遍历
 * @Author: matreeix
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

    List<Integer> list = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null)
            return list;

        for(Node node: root.children)
            postorder(node);

        list.add(root.val);

        return list;
    }

}
