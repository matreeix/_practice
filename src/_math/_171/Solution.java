package _math._171;

/**
 * @Description: 171. Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。
 * <p>
 * 例如，
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * @Author: matreeix
 * @Date: 2020/10/2
 */

public class Solution {
    public static int titleToNumber(String s) {
        int res = 0;
        for (char ch : s.toCharArray()) {
            res = res * 26 + (ch - 'A' + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AA"));
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("BA"));
    }
}
