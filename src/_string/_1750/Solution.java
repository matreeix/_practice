package _string._1750;

/**
 * @Description: 1750. 删除字符串两端相同字符后的最短长度
 * 给你一个只包含字符 'a'，'b' 和 'c' 的字符串 s ，你可以执行下面这个操作（5 个步骤）任意次：
 * 1.选择字符串 s 一个 非空 的前缀，这个前缀的所有字符都相同。
 * 2.选择字符串 s 一个 非空 的后缀，这个后缀的所有字符都相同。
 * 3.前缀和后缀在字符串中任意位置都不能有交集。
 * 4.前缀和后缀包含的所有字符都要相同。
 * 5.同时删除前缀和后缀。
 * 请你返回对字符串 s 执行上面操作任意次以后（可能 0 次），能得到的 最短长度 。
 * @Date: 2021/2/17
 */

public class Solution {

    public static int minimumLength(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (l == r) {
                return 1;
            } else if (s.charAt(l) != s.charAt(r)) {
                return r - l + 1;
            } else {
                char tmp = s.charAt(l);
                while (s.charAt(l) == tmp || s.charAt(r) == tmp) {
                    if (s.charAt(l) == tmp) l++;
                    if (s.charAt(r) == tmp) r--;
                    if (l > r) return 0;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(minimumLength("cabaabac"));//0
        System.out.println(minimumLength("aabccabba"));//3
        System.out.println(minimumLength("b"));//1
        System.out.println(minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));//1
        System.out.println(minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbb"));//0
    }
}
