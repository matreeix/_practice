package _leetcode._CONTEST._biweekly._55;

/**
 * @Description: 5781. 删除一个字符串中所有出现的给定子字符串
 * 给你两个字符串 s 和 part ，请你对 s 反复执行以下操作直到 所有 子字符串 part 都被删除：
 * 找到 s 中 最左边 的子字符串 part ，并将它从 s 中删除。
 * 请你返回从 s 中删除所有 part 子字符串以后得到的剩余字符串。
 * 一个 子字符串 是一个字符串中连续的字符序列。
 * @Created by: matreeix
 * @Date: 2021/6/26
 */
public class Solution2 {

    public static String removeOccurrences(String s, String part) {
        int len = part.length();
        while (s.contains(part)) {
            int a = s.indexOf(part);
            s = s.substring(0, a) + s.substring(a + len);
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(removeOccurrences("daabcbaabcbc","abc"));
    }
}
