package _string._415;

/**
 * @Description: 通过字符串实现整数的加法运算
 * @Author: caffebaby
 * @Date: 2020/1/5 20:36
 */
public class Solution {

    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;//存储每一位相加和的进位
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry == 1; i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);//加和的结果
            carry = (x + y + carry) / 10;//加和的进位
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "41013124234242342343402";
        String num2 = "1231232342342344234223";
        System.out.println(addStrings(num1, num2));
    }
}
