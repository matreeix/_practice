package _tree._binary_tree._95;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description: 对于给定的n，得到所有的BST可以存储值1到n
 * @Author: 67ng
 * @Date: 2020/3/22
 */
public class Solution {
    //使用动态规划
    public static List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] result = new List[n + 1];//存储n的生成BST的结果
        result[0] = new ArrayList<TreeNode>();
        if (n == 0)
            return result[0];

        result[0].add(null);
        for (int len = 1; len <= n; len++) {
            result[len] = new ArrayList<TreeNode>();
            for (int j = 0; j < len; j++) {
                for (TreeNode nodeL : result[j]) {
                    for (TreeNode nodeR : result[len - j - 1]) {
                        TreeNode node = new TreeNode(j + 1);
                        node.left = nodeL;
                        node.right = clone(nodeR, j + 1);
                        result[len].add(node);
                    }
                }
            }
        }
        return result[n];
    }

    private static TreeNode clone(TreeNode n, int offset) {
        if (n == null)
            return null;
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }


    //使用分治法
    public List<TreeNode> generateTrees2(int n) {
        if (n==0)
            return new LinkedList<TreeNode>();
        return generateSubtrees(1, n);
    }

    //从L到R生成BST
    private List<TreeNode> generateSubtrees(int L, int R) {
        List<TreeNode> res = new LinkedList<TreeNode>();
        if (L > R) {
            res.add(null); // empty tree
            return res;
        }

        for (int i = L; i <= R; ++i) {
            List<TreeNode> leftSubtrees = generateSubtrees(L, i - 1);
            List<TreeNode> rightSubtrees = generateSubtrees(i + 1, R);

            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }


    //Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
