package _leetcode._CONTEST._weekly._281;

/**
 * @Description: 6012. 统计各位数字之和为偶数的整数个数
 * 给你一个正整数 num ，请你统计并返回 小于或等于 num 且各位数字之和为 偶数 的正整数的数目。
 * 正整数的 各位数字之和 是其所有位上的对应数字相加的结果。
 * @Date: 2022/2/20
 */

public class Solution1 {
    public int countEven(int num) {
        int res = 0;
        for (int i = 1; i <= num; i++) {
            int cur = i, sum = 0;
            while (cur > 0) {
                sum += cur % 10;
                cur /= 10;
            }
            res += sum % 2 == 0 ? 1 : 0;
        }
        return res;
    }
}
