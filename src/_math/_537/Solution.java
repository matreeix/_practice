package _math._537;

/**
 * @Description:
 * @Author: matreeix
 * @Date: 2020/5/20
 */
public class Solution {
    public String complexNumberMultiply(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        int mark1 = a.indexOf('+');
        int mark2 = b.indexOf('+');

        int a1 = Integer.valueOf(a.substring(0, mark1));
        int a2 = Integer.valueOf(a.substring(mark1 + 1, len1 - 1));

        int b1 = Integer.valueOf(b.substring(0, mark2));
        int b2 = Integer.valueOf(b.substring(mark2 + 1, len2 - 1));

        int c1, c2;
        c2 = a1 * b2 + a2 * b1;
        c1 = a1 * b1 - a2 * b2;
        return "" + c1 + "+" + c2 + "i";
    }

    public static void main(String[] args) {
        String s1 = "1+-1i";
        String s2 = "1+-1i";
        System.out.println((new Solution()).complexNumberMultiply(s1, s2));
//        System.out.println(Integer.valueOf("-12"));
    }
}
