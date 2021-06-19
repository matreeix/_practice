package _leetcode._tree.n_ary_tree.T9_keyboard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 在老式手机上，用户通过数字键盘输入，手机将提供与这些数字相匹配的单词列表。每个数字映射到0至4个字母。
 * 给定一个数字序列，实现一个算法来返回匹配单词的列表。你会得到一张含有有效单词的列表。
 * 例如：
 * 输入: num = "8733", words = ["tree", "used"]
 * 输出: ["tree", "used"]
 * @Author: matreeix
 * @Date: 5/10/2020
 */
public class Solution {
    //    private Map<Character, String> map = new HashMap<>();
    private char[] chars = {'2', '2', '2', '3', '3', '3', '4', '4', '4', '5', '5', '5', '6', '6', '6', '7', '7', '7', '7', '8', '8', '8', '9', '9', '9', '9'};

    public List<String> getValidT9Words(String num, String[] words) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0 || words == null || words.length == 0)
            return res;
//        map.put('2', "abc");
//        map.put('3', "def");
//        map.put('4', "ghi");
//        map.put('5', "jkl");
//        map.put('6', "mno");
//        map.put('7', "pqrs");
//        map.put('8', "tuv");
//        map.put('9', "wxyz");
        for (String word : words)
            if (match(num, word))
                res.add(word);
        return res;
    }

    private boolean match(String num, String word) {
        if (num.length() != word.length())
            return false;

        for (int i = 0; i < num.length(); i++)
//            if (!map.get(num.charAt(i)).contains(word.charAt(i) + ""))
            if (chars[word.charAt(i) - 'a'] != num.charAt(i))
                return false;

        return true;
    }
}
