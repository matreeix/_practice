package _tree._binary_tree._515;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 找到二叉树每层的最大值
 * @Author: 67ng
 * @Date: 2020/3/10
 */
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(root);
        int max = Integer.MIN_VALUE;
        while (!q1.isEmpty() || !q1.isEmpty()) {
            while (!q1.isEmpty()) {
                TreeNode cur = q1.poll();
                if (cur.left != null) q2.add(cur.left);
                if (cur.right != null) q2.add(cur.right);
                max = Math.max(max, cur.val);
            }
            res.add(max);
            max = Integer.MIN_VALUE;
            if (q2.isEmpty()) break;
            while (!q2.isEmpty()) {
                TreeNode cur = q2.poll();
                if (cur.left != null) q1.add(cur.left);
                if (cur.right != null) q1.add(cur.right);
                max = Math.max(max, cur.val);
            }
            res.add(max);
            max = Integer.MIN_VALUE;
        }

        return res;
    }

    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }

    //d是记录二叉树的层数
    private void helper(TreeNode root, List<Integer> res, int d) {
        if (root == null) {
            return;
        }
        //expand list size
        if (d == res.size()) {
            res.add(root.val);
        } else {
            //or set value
            res.set(d, Math.max(res.get(d), root.val));
        }
        helper(root.left, res, d + 1);
        helper(root.right, res, d + 1);
    }

}
