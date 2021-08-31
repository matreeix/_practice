package _leetcode.backtracking._784;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 784. 字母大小写全排列
 * 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。
 * @Date: 2021/8/31
 */

public class Solution {

    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<String>();
        helper(S.toCharArray(), list, 0);
        return list;
    }

    private void helper(char[] c, List<String> list, int i) {
        if (i == c.length) {
            list.add(new String(c));
        } else if (Character.isLetter(c[i])) {
            c[i] = Character.toLowerCase(c[i]);
            helper(c, list, i + 1);
            c[i] = Character.toUpperCase(c[i]);
            helper(c, list, i + 1);
        } else {
            helper(c, list, i + 1);
        }
    }
}
