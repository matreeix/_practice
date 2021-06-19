package _leetcode._Cracking_the_Coding_Interview._04._09;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:面试题 04.09. 二叉搜索树序列
 * 从左向右遍历一个数组，通过不断将其中的元素插入树中可以逐步地生成一棵二叉搜索树。给定一个由不同节点组成的二叉搜索树，输出所有可能生成此树的数组。
 * @Author: matreeix
 * @Date: 2020/8/4
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

    public List<List<Integer>> BSTSequences(TreeNode root) {
        List<TreeNode> items = new ArrayList<>();
        if (root != null)
            items.add(root);
        List<Integer> tmpRes = new ArrayList<>();
        List<List<Integer>> reses = new ArrayList<>();
        dfs(items, tmpRes, reses);
        return reses;
    }

    public void dfs(List<TreeNode> items, List<Integer> tmpRes, List<List<Integer>> reses) {
        if (items.isEmpty()) {
            reses.add(new ArrayList<Integer>(tmpRes));
            return;
        }
        int len = items.size();
        for (int i = 0; i < len; i++) {
            TreeNode tmp = items.get(i);
            items.remove(i);
            if (tmp.left != null) {
                items.add(tmp.left);
            }
            if (tmp.right != null) {
                items.add(tmp.right);
            }
            tmpRes.add(tmp.val);
            dfs(items, tmpRes, reses);
            tmpRes.remove(tmpRes.size() - 1);
            items.add(i, tmp);
            items.remove(tmp.left);
            items.remove(tmp.right);
        }
    }
}
