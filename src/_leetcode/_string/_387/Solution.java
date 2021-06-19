package _leetcode._string._387;

/**
 * @Description: 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * @Author: matreeix
 * @Date: 2020/9/21
 */

public class Solution {
    public int firstUniqChar(String s) {
        int[] cnt = new int[26];
        for (char ch : s.toCharArray())
            cnt[ch - 'a']++;
        for (int i = 0; i < s.length(); i++)
            if (cnt[s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }

}
