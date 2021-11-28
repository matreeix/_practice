package _leetcode._CONTEST._biweekly._66;

/**
 * @Description: 5923. 从房屋收集雨水需要的最少水桶数
 * 给你一个下标从 0 开始的字符串 street 。street 中每个字符要么是表示房屋的 'H' ，要么是表示空位的 '.' 。
 * 你可以在 空位 放置水桶，从相邻的房屋收集雨水。位置在 i - 1 或者 i + 1 的水桶可以收集位置为 i 处房屋的雨水。一个水桶如果相邻两个位置都有房屋，那么它可以收集 两个 房屋的雨水。
 * 在确保 每个 房屋旁边都 至少 有一个水桶的前提下，请你返回需要的 最少 水桶数。如果无解请返回 -1 。
 * 提示：
 * 1 <= street.length <= 10^5
 * street[i] 要么是 'H' ，要么是 '.' 。
 * @Date: 2021/11/28
 */

public class Solution2 {
    public int minimumBuckets(String street) {
        if (!street.contains("H")) return 0;
        if ("H".equals(street)
                || street.contains("HHH")
                || street.indexOf("HH") == 0
                || street.lastIndexOf("HH") == street.length() - 2) return -1;
        int cnt = 0, cntRemove = 0, idx = -2;
        for (int i = 0; i < street.length(); i++) {
            if (street.charAt(i) == 'H') cnt++;
            if (1 <= i && i <= street.length() - 2
                    && street.charAt(i) == '.' && street.charAt(i - 1) == 'H' && street.charAt(i + 1) == 'H'
                    && i - idx > 2) {
                cntRemove++;
                idx = i;
            }
        }
        return cnt - cntRemove;
    }
}
