package _string._67;

/**
 * @Description: 将两个二进制数字的字符串加和
 * @Author: caffebaby
 * @Date: 2020/3/1
 */
public class Solution {
    public static String addBinary(String a, String b) {
        int len1 = a.length(), len2 = b.length();
        char[] long_ch = len1 > len2 ? a.toCharArray() : b.toCharArray();//长字符串
        char[] short_ch = len1 > len2 ? b.toCharArray() : a.toCharArray();//短字符串

        int long_index = long_ch.length - 1;
        int short_index = short_ch.length - 1;
        int carried = 0;
        String res = "";
        while (long_index > -1) {
            int i = long_ch[long_index] - 48;
            int j = short_index == -1 ? 0 : short_ch[short_index] - 48;
            res = (i + j + carried) % 2 + res;
            carried = (i + j + carried) / 2;

            long_index = long_index - 1;
            short_index = short_index <= 0 ? -1 : short_index - 1;
        }
        res = carried == 1 ? 1 + res : res;
        return res;
    }

    public String addBinary2(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("111", "1"));
        System.out.println(addBinary("1010", "1011"));


    }
}
