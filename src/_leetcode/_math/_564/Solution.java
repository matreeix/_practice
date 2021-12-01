package _leetcode._math._564;

/**
 * @Description: 564. 寻找最近的回文数
 * 给定一个整数 n ，你需要找到与它最近的回文数（不包括自身）。
 * “最近的”定义为两个整数差的绝对值最小。
 * @Date: 2021/11/25
 */

public class Solution {
    private long getPossiblePalindromic(String leftHalf, int addNum, int needBit) {
        leftHalf = Long.toString(Long.parseLong(leftHalf) + addNum);
        int n = leftHalf.length();
        StringBuilder sb = new StringBuilder();
        sb.append(leftHalf, 0, Math.min(n, needBit)).reverse().insert(0, leftHalf);
        if (n < needBit) sb.append('9');
        return Long.parseLong(sb.toString());
    }

    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n), ans = 0;
        if (num == 11 || num == 10) return "9";
        int len = n.length();
        String leftHalf = n.substring(0, len + 1 >> 1);
        long palindromic1 = getPossiblePalindromic(leftHalf, -1, len >> 1);
        long palindromic2 = getPossiblePalindromic(leftHalf, 0, len >> 1);
        long palindromic3 = getPossiblePalindromic(leftHalf, 1, len >> 1);
        long dis1 = Math.abs(num - palindromic1), dis2 = Math.abs(num - palindromic2), dis3 = Math.abs(num - palindromic3);
        ans = dis1 <= dis3 ? palindromic1 : palindromic3;
        dis1 = Math.min(dis1, dis3);
        if (dis2 == 0 || dis2 > dis1) return Long.toString(ans);
        ans = dis1 == dis2 ? Math.min(palindromic2, ans) : palindromic2;
        return Long.toString(ans);
    }

}
