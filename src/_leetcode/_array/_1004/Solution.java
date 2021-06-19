package _leetcode._array._1004;

/**
 * @Description: 1004. 最大连续1的个数 III
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * 返回仅包含 1 的最长（连续）子数组的长度
 * @Author: matreeix
 * @Date: 2020/7/24
 */

public class Solution {
    //滑动窗口，在[i，j]中维护一个含有k个零的窗口
    public int longestOnes(int[] A, int K) {
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0)
                K--;
            if (K < 0 && A[i++] == 0)
                K++;
        }
        return j - i;
    }
}
