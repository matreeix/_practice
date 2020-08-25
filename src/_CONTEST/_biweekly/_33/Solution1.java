package _CONTEST._biweekly._33;

/**
 * @Description: 5479. 千位分隔数
 * 给你一个整数 n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，并将结果以字符串格式返回。
 * @Author: matreeix
 * @Date: 2020/8/22
 */

public class Solution1 {
    public static String thousandSeparator(int n) {
        String res = n + "";
        int len = res.length();
        if (len < 4) return res;
        int mark = len - 3;
        while (mark > 0) {
            res = res.substring(0, mark) + "." + res.substring(mark);
            mark -= 3;
        }
        return res;
    }

    public static String thousandSeparator2(int n) {
        String s = Integer.toString(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && (s.length() - i) % 3 == 0) {
                sb.append(".");
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(thousandSeparator(0));
        System.out.println(thousandSeparator(100));
        System.out.println(thousandSeparator(100000));
        System.out.println(thousandSeparator(1234123434));
        System.out.println(thousandSeparator(51040));
    }
}
