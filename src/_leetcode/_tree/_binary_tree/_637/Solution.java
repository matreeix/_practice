package _leetcode._tree._binary_tree._637;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description: 637. 二叉树的层平均值
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * @Date: 2021/3/28
 */

public class Solution {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private final List<List<Integer>> levels = new ArrayList<>();

    //递归
    public List<Double> averageOfLevels(TreeNode root) {
        helper(root, 0);
        List<Double> res = new ArrayList<>();
        for (List<Integer> level : levels) {
            double tmp = 0.0;
            for (int v : level) tmp += v;
            res.add(tmp / level.size());
        }
        return res;
    }

    private void helper(TreeNode node, int level) {
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

        levels.get(level).add(node.val);

        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }

    //非递归
    public List<Double> averageOfLevels2(TreeNode root) {
        List<Double> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        double sum = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            res.add(sum / size);
            sum = 0;
        }

        return res;
    }

}
