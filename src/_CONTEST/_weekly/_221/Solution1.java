package _CONTEST._weekly._221;

/**
 * @Description: 5637. 判断字符串的两半是否相似
 * 给你一个偶数长度的字符串 s 。将其拆分成长度相同的两半，前一半为 a ，后一半为 b 。
 * 两个字符串 相似 的前提是它们都含有相同数目的元音（'a'，'e'，'i'，'o'，'u'，'A'，'E'，'I'，'O'，'U'）。注意，s 可能同时含有大写和小写字母。
 * 如果 a 和 b 相似，返回 true ；否则，返回 false 。
 * @Date: 2020/12/27
 */

public class Solution1 {
    public boolean halvesAreAlike(String s) {
        int cnt1 = 0, cnt2 = 0, n = s.length();
        String tmp = "aeiouAEIOU";
        for (int i = 0, j = n / 2; i < n / 2; i++, j++) {
            if (tmp.contains(s.charAt(i) + "")) cnt1++;
            if (tmp.contains(s.charAt(j) + "")) cnt2++;
        }
        return cnt1 == cnt2;
    }
}
