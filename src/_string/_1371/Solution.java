package _string._1371;

import java.util.HashMap;

/**
 * @Description: 1371. 每个元音包含偶数次的最长子字符串
 * 给你一个字符串 s ，请你返回满足以下条件的最长子字符串的长度：
 * 每个元音字母，即 'a'，'e'，'i'，'o'，'u' ，在子字符串中都恰好出现了偶数次。
 * @Author: matreeix
 * @Date: 2020/8/10
 */

public class Solution {

    public int findTheLongestSubstring(String s) {
        int res = 0, cur = 0;
        HashMap<Integer, Integer> seen = new HashMap<>();
        seen.put(0, -1);
        for (int i = 0; i < s.length(); ++i) {
            cur ^= 1 << ("aeiou".indexOf(s.charAt(i)) + 1) >> 1;//0,1,2,4,8,16,只要cur!=0，说明某个元音出现奇数次
            seen.putIfAbsent(cur, i);//cur只记录元音奇数次第一次出现的情况
            res = Math.max(res, i - seen.get(cur));
        }
        return res;
    }

    public static void main(String[] args) {

    }
}