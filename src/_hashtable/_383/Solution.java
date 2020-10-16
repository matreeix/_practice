package _hashtable._383;

/**
 * @Description: 383. 赎金信
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * <p>
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 * @Author: matreeix
 * @Date: 2020/10/16
 */

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (char ch : ransomNote.toCharArray())
            cnt1[ch - 'a']++;
        for (char ch : magazine.toCharArray())
            cnt2[ch - 'a']++;

        for (int i = 0; i < 26; i++)
            if (cnt1[i] > cnt2[i])
                return false;

        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int caps[] = new int[26];
        for(char c : ransomNote.toCharArray()){
            int index = magazine.indexOf(c,caps[c-'a']);
            if (index == -1) {
                return false;
            }
            caps[c - 'a'] = index + 1;
        }


        return true;
    }
}
