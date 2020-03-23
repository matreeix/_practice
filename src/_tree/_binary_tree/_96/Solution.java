package _tree._binary_tree._96;

/**
 * @Description: 对于给定的n，有多少个BST可以存储值1到n
 * @Author: 67ng
 * @Date: 2020/3/22
 */

public class Solution {
    public int numTrees(int n) {
        int [] mem = new int[n+1];
        mem[0] = mem[1] = 1;
        for(int i=2; i<=n; ++i) {
            for(int j=1; j<=i; ++j) {//mem[i]等于分别以1,2...i为根节点的BST个数
                mem[i] += mem[j-1] * mem[i-j];//mem[i] = sum(mem[左节点数]*mem[右节点数])
            }
        }
        return mem[n];
    }


    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
