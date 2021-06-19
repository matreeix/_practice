package _leetcode._CONTEST._weekly._204;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 5502. 将子数组重新排序得到同一个二叉查找树的方案数
 * 给你一个数组 nums 表示 1 到 n 的一个排列。我们按照元素在 nums 中的顺序依次插入一个初始为空的二叉查找树（BST）。
 * 请你统计将 nums 重新排序后，统计满足如下条件的方案数：重排后得到的二叉查找树与 nums 原本数字顺序得到的二叉查找树相同。
 * 比方说，给你 nums = [2,1,3]，我们得到一棵 2 为根，1 为左孩子，3 为右孩子的树。数组 [2,3,1] 也能得到相同的 BST，但 [3,2,1] 会得到一棵不同的 BST 。
 * 请你返回重排 nums 后，与原数组 nums 得到相同二叉查找树的方案数。
 * <p>
 * 由于答案可能会很大，请将结果对 10^9 + 7 取余数。
 * @Author: matreeix
 * @Date: 2020/8/30
 */

public class Solution4 {
    private static final long MOD = 1000000007;
    private static final long[][] triangle = getTriangle(1001);

    public int numOfWays(int[] nums) {
        int len = nums.length;
        List<Integer> arr = new ArrayList<>();
        for (int n : nums) {
            arr.add(n);
        }
        return (int) getCombs(arr) - 1;
    }

    private long getCombs(List<Integer> nums) {
        if (nums.size() <= 2) {
            return 1;
        }
        int root = nums.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int n : nums) {
            if (n < root) {
                left.add(n);
            } else if (n > root) {
                right.add(n);
            }
        }
        // mod every number to avoid overflow
        return (triangle[left.size() + right.size()][left.size()] * (getCombs(left) % MOD) % MOD) * getCombs(right) % MOD;
//        return (dp[left.size() + right.size()][left.size()] * (getCombs(left) % MOD) % MOD) * getCombs(right) % MOD;
    }

//     Yang Hui (Pascle) triangle
    private static long[][] getTriangle(int n) {
        // 4C2 = triangle[4][2] = 6
        long[][] triangle = new long[n][n];
        for (int i = 0; i < n; i++) {
            triangle[i][0] = triangle[i][i] = 1;
        }
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                triangle[i][j] = (triangle[i - 1][j] + triangle[i - 1][j - 1]) % MOD;
            }
        }
        return triangle;
    }

//    int[][] dp = new int[1001][1001];
//
//    private int comb(int n, int m) {
//        return n == 0 || m == 0 ? 1 :
//                (dp[n][m] != 0 ? dp[n][m] : (dp[n][m] = (comb(n - 1, m) + comb(n, m - 1)) % 1000000007));
//    }

}
