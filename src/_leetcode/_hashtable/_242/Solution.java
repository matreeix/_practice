package _leetcode._hashtable._242;

/**
 * @Description: 有效的字母异位词
 * <p>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * @Author: matreeix
 * @Date: 2020/6/28
 */

public class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            count[ch - 'a']--;
        }
        for (int i : count)
            if (i != 0)
                return false;
        return true;
    }
}
