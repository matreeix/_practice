package _leetcode._CONTEST._weekly._279;

import java.util.Arrays;

/**
 * @Description:2165. 重排数字的最小值
 * 给你一个整数 num 。重排 num 中的各位数字，使其值 最小化 且不含 任何 前导零。
 * 返回不含前导零且值最小的重排数字。
 * 注意，重排各位数字后，num 的符号不会改变。
 * 提示：
 * -10^15 <= num <= 10^15
 * @Date: 2022/2/7
 */

public class Solution2 {
    public long smallestNumber(long num) {
        if (num == 0) return num;
        long tmp = Math.abs(num);
        int[] cnt = new int[10];
        while (tmp > 0) {
            cnt[(int) (tmp % 10L)]++;
            tmp /= 10;
        }
        if (num > 0) {
            long res = 0;
            for (int i = 1; i < cnt.length; i++)
                while (cnt[i]-- > 0)
                    res = res * 10 + i;
            if (cnt[0] > 0) {
                String s = Long.toString(res);
                String zero = "";
                while (cnt[0]-- > 0) zero += "0";
                s = s.charAt(0) + zero + s.substring(1);
                return Long.parseLong(s);
            }
            return res;
        } else {
            long res = 0;
            for (int i = 9; i >= 0; i--)
                while (cnt[i]-- > 0)
                    res = res * 10 + i;
            return -res;
        }
    }

    public static void main(String[] args) {
//        System.out.println((new Solution2()).smallestNumber(310));
//        System.out.println((new Solution2()).smallestNumber(-7605));
        System.out.println((new Solution2()).smallestNumber(2170596702L));
    }
}
