package _leetcode._bit_calc._868;

/**
 * @Description: 868. 二进制间距
 * 给定一个正整数 n，找到并返回 n 的二进制表示中两个 相邻 1 之间的 最长距离 。如果不存在两个相邻的 1，返回 0 。
 * 如果只有 0 将两个 1 分隔开（可能不存在 0 ），则认为这两个 1 彼此 相邻 。两个 1 之间的距离是它们的二进制表示中位置的绝对差。例如，"1001" 中的两个 1 的距离为 3 。
 * @Created by: matreeix
 * @Date: 2021/5/5
 */
public class Solution {
    public static int binaryGap(int n) {
        if ((n & (n - 1)) == 0) return 0;
        int res = 0;
        int start = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (start != 0) {
                    res = Math.max(res, start);
                    start = 1;
                } else {
                    start++;
                }
            } else {
                start = start == 0 ? 0 : start + 1;
            }
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(binaryGap(22));//2
        System.out.println(binaryGap(5));//2
        System.out.println(binaryGap(6));//1
        System.out.println(binaryGap(8));//0
        System.out.println(binaryGap(12));//1
        System.out.println(binaryGap(21));//2
    }
}
