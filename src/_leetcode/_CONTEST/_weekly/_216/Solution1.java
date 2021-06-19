package _leetcode._CONTEST._weekly._216;

/**
 * @Description: 1662. 检查两个字符串数组是否相等
 * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 * <p>
 * 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
 * @Author: matreeix
 * @Date: 2020/11/24
 */

public class Solution1 {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0, j = 0, ii = 0, jj = 0;
        while (i < word1.length && j < word2.length) {
            while (ii < word1[i].length() && jj < word2[j].length()) {
                if (word1[i].charAt(ii) == word2[j].charAt(jj)) {
                    ii++;
                    jj++;
                } else {
                    return false;
                }
            }
            if (ii == word1[i].length()) {
                i++;
                ii = 0;
            }
            if (jj == word2[j].length()) {
                j++;
                jj = 0;
            }
        }
        if (i != word1.length || j != word2.length)
            return false;
        return true;
    }

    public boolean arrayStringsAreEqual2(String[] word1, String[] word2) {
        StringBuilder w1 = new StringBuilder();
        StringBuilder w2 = new StringBuilder();
        for (String s : word1) {
            w1.append(s);
        }
        for (String s : word2) {
            w2.append(s);
        }
        return w1.toString().equals(w2.toString());
    }

    public static void main(String[] args) {
        String[] word1 = {"a", "cb"};
        String[] word2 = {"a", "bc"};
        System.out.println(arrayStringsAreEqual(word1, word2));
    }


}
