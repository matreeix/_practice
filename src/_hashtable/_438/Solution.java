package _hashtable._438;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 找出所有字母异位词
 * <p>
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 说明：
 * 1.字母异位词指字母相同，但排列不同的字符串。
 * 2.不考虑答案输出的顺序。
 *
 * @Author: Pythagodzilla
 * @Date: 2020/6/28
 */

public class Solution {

    //滑动窗口和哈希表
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int[] needs = new int[26]; //由于都是小写字母，因此直接用26个长度的数组代替原来的HashMap
        int[] window = new int[26];
        int left = 0, right = 0, total = p.length(); //用total检测窗口中是否已经涵盖了p中的字符
        for (char ch : p.toCharArray())
            needs[ch - 'a']++;

        while (right < s.length()) {
            char chr = s.charAt(right);
            if (needs[chr - 'a'] > 0) {
                window[chr - 'a']++;
                if (window[chr - 'a'] <= needs[chr - 'a'])
                    total--;
            }
            while (total == 0) {
                if (right - left + 1 == p.length())
                    res.add(left);

                char chl = s.charAt(left);
                if (needs[chl - 'a'] > 0) {
                    window[chl - 'a']--;
                    if (window[chl - 'a'] < needs[chl - 'a'])
                        total++;

                }
                left++;
            }
            right++;
        }
        return res;
    }
}