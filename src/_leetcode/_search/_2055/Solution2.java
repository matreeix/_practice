package _leetcode._search._2055;

import java.util.Arrays;

/**
 * @Description:
 * @Date: 2021/11/3
 */

public class Solution2 {
    public static int[] platesBetweenCandles(String s, int[][] queries) {
        s += "|";// 补齐边界条件
        final int N = s.length();
        int[] lefts = new int[N];// 两个蜡烛之间的盘子数都等于左边蜡烛的前缀数
        int[] rights = new int[N];// 两个蜡烛之间的盘子数都等于右边蜡烛的前缀数
        int count = 0;// 记录 * 的个数
        int tmp = 0;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == '|') {
                tmp = count;
                for (; idx <= i; idx++)
                    rights[idx] = count;
            } else {
                count++;
            }
            lefts[i] = tmp;
        }
        final int qLen = queries.length;
        int[] ans = new int[qLen];
        for (int i = 0; i < qLen; i++) {
            int[] q = queries[i];
            ans[i] = Math.max(0, lefts[q[1]] - rights[q[0]]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] q = {{2, 2}};
        System.out.println(Arrays.toString(platesBetweenCandles("*|*", q)));
    }
}
