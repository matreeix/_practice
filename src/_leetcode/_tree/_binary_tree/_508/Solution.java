package _leetcode._tree._binary_tree._508;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 508. 出现次数最多的子树元素和
 * 给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * 你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 * @Date: 2021/7/1
 */

public class Solution {


    public class TreeNode {
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

    private Map<Integer, Integer> map;
    public int[] findFrequentTreeSum(TreeNode root) {
        map = new HashMap<>();
        dfs(root);
        int max = 0;
        for (int val : map.values()) {
            max = Math.max(max, val);
        }
        List<Integer> res = new ArrayList<>();
        for (int sum : map.keySet()) {
            if (map.get(sum) == max)
                res.add(sum);
        }
        return res.stream().mapToInt(i -> i).toArray();

    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int sum = dfs(node.left) + dfs(node.right) + node.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
