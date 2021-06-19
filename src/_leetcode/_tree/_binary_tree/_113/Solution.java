package _leetcode._tree._binary_tree._113;

import java.util.*;

/**
 * @Description: 求出从根节点到叶子节点和为指定sum的路径
 * @Author: matreeix
 * @Date: 2020/2/13
 */
public class Solution {

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        List<Integer> currentRes = new LinkedList<Integer>();
        pathSum(root, sum, currentRes, res);
        return res;
    }

    public static void pathSum(TreeNode root, int sum, List<Integer> currentRes,List<List<Integer>> result) {
        if (root == null)
            return;
        currentRes.add(new Integer(root.val));
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new LinkedList(currentRes));
            currentRes.remove(currentRes.size() - 1);//don't forget to remove the last integer
            return;
        } else {
            pathSum(root.left, sum - root.val, currentRes, result);
            pathSum(root.right, sum - root.val, currentRes, result);
        }
        currentRes.remove(currentRes.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.right = new TreeNode(8);
        treeNode.left.left = new TreeNode(11);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);

        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.right.left = new TreeNode(5);
        treeNode.right.right.right = new TreeNode(1);

        System.out.println(pathSum(treeNode, 22));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
