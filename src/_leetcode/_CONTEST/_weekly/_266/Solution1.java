package _leetcode._CONTEST._weekly._266;

/**
 * @Description: 5918. 统计字符串中的元音子字符串
 * 子字符串 是字符串中的一个连续（非空）的字符序列。
 * 元音子字符串 是 仅 由元音（'a'、'e'、'i'、'o' 和 'u'）组成的一个子字符串，且必须包含 全部五种 元音。
 * 给你一个字符串 word ，统计并返回 word 中 元音子字符串的数目 。
 * @Date: 2021/11/7
 */

public class Solution1 {
    public int countVowelSubstrings(String word) {
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 5; j <= word.length(); j++) {
                String tmp = word.substring(i, j);
                if (check(tmp)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean check(String s) {
        boolean a = false;
        boolean e = false;
        boolean i = false;
        boolean o = false;
        boolean u = false;
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case 'a':
                    a = true;
                    break;
                case 'e':
                    e = true;
                    break;
                case 'i':
                    i = true;
                    break;
                case 'o':
                    o = true;
                    break;
                case 'u':
                    u = true;
                    break;
                default:
                    return false;
            }
        }
        return a && e && i && o && u;
    }
}
