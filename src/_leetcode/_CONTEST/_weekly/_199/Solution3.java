package _leetcode._CONTEST._weekly._199;

/**
 * @Description: 5474. 好叶子节点对的数量
 * <p>
 * 给你二叉树的根节点 root 和一个整数 distance 。
 * 如果二叉树中两个叶节点之间的最短路径长度 小于或者等于 distance,那它们就可以构成一组好叶子节点对 。
 * 返回树中 好叶子节点对的数量 。
 * @Author: matreeix
 * @Date: 2020/7/26
 */

public class Solution3 {
    int res = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return res;
    }

    //得到叶子节点的深度数组
    public int[] dfs(TreeNode root, int distance) {
        if (root == null) return new int[0];
        if (root.left == null && root.right == null) return new int[]{1};
        int[] left = dfs(root.left, distance), right = dfs(root.right, distance);
        for (int l : left)//统计左子树和右子树符合条件叶子节点的对数
            for (int r : right)
                if (l + r <= distance)
                    res++;
        int idx = 0;//index
        int[] cur = new int[left.length + right.length];
        for (int l : left)
            cur[idx++] = l + 1;
        for (int r : right)
            cur[idx++] = r + 1;
        return cur;
    }

    public static void main(String[] args) {

    }
}

class TreeNode {
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