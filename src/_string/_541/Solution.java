package _string._541;

/**
 * @Description: 反转字符串II
 * <p>
 * 给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 * 1.如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 2.如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * *1
 * @Author: caffebaby
 * @Date: 2020/7/4
 */

public class Solution {
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }

    public static void main(String[] args) {
        String s1 = "abcdefg";
        int k = 2;
        System.out.println((new Solution()).reverseStr(s1, k));
    }
}
