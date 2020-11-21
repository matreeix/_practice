package _CONTEST._weekly._215;

import java.util.Arrays;

/**
 * @Description: 1657. 确定两个字符串是否接近
 * 如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
 * <p>
 * 操作 1：交换任意两个 现有 字符。
 * 例如，abcde -> aecdb
 * 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
 * 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
 * 你可以根据需要对任意一个字符串多次使用这两种操作。
 * <p>
 * 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
 * <p>
 * 提示：
 * <p>
 * 1 <= word1.length, word2.length <= 105
 * word1 和 word2 仅包含小写英文字母
 * @Author: matreeix
 * @Date: 2020/11/21
 */

public class Solution2 {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            cnt1[word1.charAt(i) - 'a']++;
            cnt2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < cnt2.length; i++) //确保俩字符串必须都含有相同的字符
            if (cnt1[i] * cnt2[i] == 0 && Math.max(cnt1[i], cnt2[i]) != 0)
                return false;
        Arrays.sort(cnt1);
        Arrays.sort(cnt2);
        for (int i = 0; i < cnt2.length; i++) //含有字符的数目统计必须一样
            if (cnt1[i] != cnt2[i])
                return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(0^0);
        System.out.println(0^1);
        System.out.println(2^2);
    }
}
