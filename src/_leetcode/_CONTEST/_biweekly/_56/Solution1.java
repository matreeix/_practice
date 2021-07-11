package _leetcode._CONTEST._biweekly._56;

/**
 * @Description: 5792. 统计平方和三元组的数目
 * 一个 平方和三元组 (a,b,c) 指的是满足 a2 + b2 = c2 的 整数 三元组 a，b 和 c 。
 * 给你一个整数 n ，请你返回满足 1 <= a, b, c <= n 的 平方和三元组 的数目。
 * @Date: 2021/7/10
 */

public class Solution1 {

    public int countTriples(int n) {
        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                for (int k = j + 1; k <= n; k++) {
                    if (i * i + j * j == k * k) {
                        if (i == j) res++;
                        else res += 2;
                    }
                }
            }
        }
        return res;
    }
}
