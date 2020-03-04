package _string._273;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Stack;

/**
 * @Description: 数字翻译成英文
 * @Author: 67ng
 * @Date: 2020/3/3
 */
public class Solution {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String res = "";
        if (num >= 1_000_000_000)
            res += num2String(num / 1_000_000_000) + " Billion ";
        num %= 1_000_000_000;
        if (num >= 1_000_000)
            res += num2String(num / 1_000_000) + " Million ";
        num %= 1_000_000;
        if (num >= 1_000)
            res += num2String(num / 1_000) + " Thousand ";
        num %= 1_000;
        res += num2String(num);

        return res.trim();
    }

    public String num2String(int num) {//0<num < 1000
        String EnglishNum = "";
        int res = Integer.MAX_VALUE;
        int a = num / 100;
        if (a > 0)
            EnglishNum += bit2String(a) + " " + "Hundred" + " ";
        int b = (num % 100) / 10;
        if (b > 1) {
            EnglishNum += bit2String(b * 10) + " " + bit2String(num % 10) + " ";
        } else
            EnglishNum += bit2String(num % 100);

        return EnglishNum.trim();
    }

    public String bit2String(int num) {//0<=num<100
        switch (num) {
            case 0:
                return "";
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
            case 20:
                return "Twenty";
            case 30:
                return "Thirty";
            case 40:
                return "Forty";
            case 50:
                return "Fifty";
            case 60:
                return "Sixty";
            case 70:
                return "Seventy";
            case 80:
                return "Eighty";
            case 90:
                return "Ninety";
        }
        return "Unrecognized";
    }

    public static void main(String[] args) {
        int num1 = 1000000;
        int num2 = 1_234_567;
        int num3 = 1_234_000_100;
        System.out.println((new Solution()).numberToWords(num1));
        System.out.println((new Solution()).numberToWords(num2));
        System.out.println((new Solution()).numberToWords(num3));

//        System.out.println(num2String(123));
//        System.out.println(num2String(110));
//        System.out.println(num2String(23));
//        System.out.println(num2String(16));
//        System.out.println(num2String(3));
//        System.out.println(num2String(0));
    }

}
