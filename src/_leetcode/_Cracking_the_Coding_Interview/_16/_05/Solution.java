package _leetcode._Cracking_the_Coding_Interview._16._05;

/**
 * @Description: 面试题 16.05. 阶乘尾数
 * 设计一个算法，算出 n 阶乘有多少个尾随零。
 * @Author: matreeix
 * @Date: 2020/10/22
 */

public class Solution {
    public int trailingZeroes(int n) {
        int m5 = 0;
        while (n > 0) {
            m5 += n / 5;
            n /= 5;
        }
        return m5;
    }
}
