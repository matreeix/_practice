package _leetcode._CONTEST._weekly._252;

/**
 * @Description: 5830. 三除数
 * 给你一个整数 n 。如果 n 恰好有三个正除数 ，返回 true ；否则，返回 false 。
 * 如果存在整数 k ，满足 n = k * m ，那么整数 m 就是 n 的一个 除数 。
 * @Date: 2021/8/1
 */

public class Solution1 {

    public boolean isThree(int n) {
        int res = 0;
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                res++;
        return res == 1;
    }
}
