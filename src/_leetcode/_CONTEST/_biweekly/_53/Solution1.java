package _leetcode._CONTEST._biweekly._53;

/**
 * @Description: 5754. 长度为三且各字符不同的子字符串
 * 如果一个字符串不含有任何重复字符，我们称这个字符串为 好 字符串。
 * 给你一个字符串 s ，请你返回 s 中长度为 3 的 好子字符串 的数量。
 * 注意，如果相同的好子字符串出现多次，每一次都应该被记入答案之中。
 * <p>
 * 子字符串 是一个字符串中连续的字符序列。
 * @Created by: matreeix
 * @Date: 2021/5/29
 */
public class Solution1 {

    public static int countGoodSubstrings(String s) {
        int res = 0;
        for (int i = 0; i + 2 < s.length(); i++) {
            String str = s.substring(i, i + 3);
            System.out.println(i);
            if (str.charAt(0) == str.charAt(1)
                    || str.charAt(1) == str.charAt(2)
                    || str.charAt(0) == str.charAt(2)) continue;
            else res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countGoodSubstrings("aababcabc"));
    }

}
