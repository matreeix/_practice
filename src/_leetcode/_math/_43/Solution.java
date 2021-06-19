package _leetcode._math._43;

/**
 * @Description: 字符串的乘法, 其实就是乘法的运算方法
 * @Author: matreeix
 * @Date: 2019/7/30 20:21
 */
public class Solution {
    public static String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int[] products = new int[n1 + n2];//乘积的位数不大于乘数位数之和
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';//ASCII码运算
                int d2 = num2.charAt(j) - '0';
                products[i + j + 1] += d1 * d2;
            }
        }
        int carry = 0;
        for (int i = products.length - 1; i >= 0; i--) {
            int tmp = (products[i] + carry) % 10;//保存末位
            carry = (products[i] + carry) / 10;//保存进位
            products[i] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : products) sb.append(num);
        while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();

    }


    public static void main(String[] args) {
        String str1 = "123";
        String str2 = "45";
        System.out.println(multiply(str1, str2));
        System.out.println('6' - 'a');
    }
}
