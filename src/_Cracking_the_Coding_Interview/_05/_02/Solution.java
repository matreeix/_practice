package _Cracking_the_Coding_Interview._05._02;

/**
 * @Description: 面试题 05.02. 二进制数转字符串
 * 二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。
 * 如果该数字不在0和1之间，或者无法精确地用32位以内的二进制表示，则打印“ERROR”。
 * @Author: Pythagodzilla
 * @Date: 2020/6/29
 */

public class Solution {
    public static String printBin(double num) {
        if (num >= 1.0 || num <= 0.0) return "ERROR";
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        int count = 30;
        while (num != 0.0 && count > -1) {
            num *= 2;
            int bit = (int) Math.floor(num);
            sb.append(bit);
            num -= bit;
            System.out.println(num);
            count--;
        }
        return count == -1 ? "ERROR" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(printBin(0.2868311060592532));//0.286831106059253215789794921875
    }

}
