package _math._504;

/**
 * @Description: 504. 七进制数
 * 给定一个整数，将其转化为7进制，并以字符串形式输出。
 * @Author: matreeix
 * @Date: 2020/9/26
 */

public class Solution {
    public static String convertToBase7(int num) {
        String s = "";
        int res = Math.abs(num);
        while (res > 6) {
            s = res % 7 + s;
            res = res / 7;
        }
        s = res + s;
        return num < 0 ? "-" + s : s;
    }

    public String convertToBase7_2(int num) {
        return Integer.toString(num, 7);
    }

    public static void main(String[] args) {
        System.out.println(convertToBase7(100));
        System.out.println(convertToBase7(0));
        System.out.println(convertToBase7(-100));
        System.out.println(convertToBase7(7));
    }
}
