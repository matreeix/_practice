package _CONTEST._biweekly._32;

import java.util.Arrays;

/**
 * @Description: 5485. 找出最长的超赞子字符串
 * 给你一个字符串 s 。请返回 s 中最长的 超赞子字符串 的长度。
 * 「超赞子字符串」需满足满足下述两个条件：
 * 1.该字符串是 s 的一个非空子字符串
 * 2.进行任意次数的字符交换重新排序后，该字符串可以变成一个回文字符串
 * @Author: matreeix
 * @Date: 2020/8/8
 */

public class Solution4 {
    public int longestAwesome(String s) {
        int res = 0, cur = 0, n = s.length(), seen[] = new int[1024];//统计各数字出现次数
        Arrays.fill(seen, n);
        seen[0] = -1;
        for (int i = 0; i < n; ++i) {
            cur ^= 1 << (s.charAt(i) - '0');
            for (int j = 0; j < 10; ++j)//以0-9为中心的回文
                res = Math.max(res, i - seen[cur ^ (1 << j)]);
            res = Math.max(res, i - seen[cur]);//偶数个数的回文
            seen[cur] = Math.min(seen[cur], i);//seen记录次数的最小值
        }
        return res;
    }
}
