package _leetcode._string._1781;

/**
 * @Description: 1781. 所有子字符串美丽值之和
 * 一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。
 * 比方说，"abaacc" 的美丽值为 3 - 1 = 2 。
 * 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。
 * @Date: 2021/3/8
 */

public class Solution {
    public static int beautySum(String s) {
        if (s.length() < 3) return 0;
        int res = 0;
        char[] chs = s.toCharArray();

        for (int i = 0; i < chs.length; i++) {
            int[] cnt = new int[26];
            for (int j = i; j < chs.length; j++) {//遍历每个子字符串
                cnt[chs[j] - 'a']++;
                int max = 0, min = 1000;
                for (int num : cnt) {
                    if (num > 0) {
                        max = Math.max(max, num);
                        min = Math.min(min, num);
                    }
                }
                res += max - min;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(beautySum("aabcb"));
    }

}
