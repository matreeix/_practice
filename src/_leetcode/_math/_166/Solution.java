package _leetcode._math._166;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 分数转成小数
 * @Author: matreeix
 * @Date: 2020/3/4
 */
public class Solution {
    public static String fractionToDecimal(int numerator, int denominator) {
        long a = numerator, b = denominator;
        if (a == 0) return "0";
        StringBuilder res = new StringBuilder();
        if (a * b < 0) {
            res.append("-");
            a = Math.abs(a);
            b = Math.abs(b);
        }
        long integer = a / b;
        res.append(integer);
        if (a % b == 0) return res.toString();
        Map<Long, Long> rembit = new HashMap<>();
        long count = 0;
        long len = -1;
        a = a % b;
        long tmp = 0;
        res.append(".");

        while (true) {//查找小数部分
            if (a == 0)
                break;
            if (rembit.containsKey(a)) {
                len = rembit.get(a);
                res.append(")");
                break;
            } else
                rembit.put(a, count++);
            a = a * 10;
            tmp = a / b;
            res.append(tmp);
            a = a % b;
        }
        if (len > -1)
            return res.insert((int) (res.length() - rembit.size() - 1 + len), '(').toString();
        else
            return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(7, 51));
        System.out.println(fractionToDecimal(1, 3));
        System.out.println(fractionToDecimal(2, 1));
        System.out.println(fractionToDecimal(1, 4));
        System.out.println(fractionToDecimal(-2147483648, 1));

    }
}
