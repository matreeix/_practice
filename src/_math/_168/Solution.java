package _math._168;

/**
 * @Description: 168. Excel表列名称
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 例如，
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * @Author: matreeix
 * @Date: 2020/10/2
 */

public class Solution {
    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            char a = (char) ((n - 1) % 26 + 'A');
            sb.insert(0, a);
            if (n % 26 != 0) n /= 26;
            else n = n / 26 - 1;
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(4));
        System.out.println(convertToTitle(25));
        System.out.println(convertToTitle(26));
        System.out.println(convertToTitle(27));
        System.out.println(convertToTitle(52));

        System.out.println((char) (25 + 'A'));
    }
}
