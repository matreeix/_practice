package _tree._binary_tree._653;

import java.util.*;

/**
 * @Description: 653. 两数之和 IV - 输入 BST
 * 给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * @Date: 2021/3/28
 */

public class Solution {
    private class TreeNode {
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

    private List<Integer> list = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        dfs(root);
        int l = 0, r = list.size() - 1;
        while (l < r)
            if (list.get(l) + list.get(r) > k) r--;
            else if (list.get(l) + list.get(r) < k) l++;
            else return true;

        return false;

    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }

    public boolean findTarget2(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    public boolean dfs(TreeNode root, HashSet<Integer> set, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }

    //在BST找值
    private boolean findVal(TreeNode root, int v) {
        if (root == null) return false;
        if (root.val == v) return true;
        else if (root.val < v) return findVal(root.right, v);
        else return findVal(root.left, v);
    }
}
