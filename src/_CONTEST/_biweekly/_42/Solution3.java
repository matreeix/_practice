package _CONTEST._biweekly._42;

import java.util.Arrays;

/**
 * @Description: 1702. 修改后的最大二进制字符串
 * 给你一个二进制字符串 binary ，它仅有 0 或者 1 组成。你可以使用下面的操作任意次对它进行修改：
 * 操作 1 ：如果二进制串包含子字符串 "00" ，你可以用 "10" 将其替换。
 * 比方说， "00010" -> "10010"
 * 操作 2 ：如果二进制串包含子字符串 "10" ，你可以用 "01" 将其替换。
 * 比方说， "00010" -> "00001"
 * 请你返回执行上述操作任意次以后能得到的 最大二进制字符串 。如果二进制字符串 x 对应的十进制数字大于二进制字符串 y 对应的十进制数字，那么我们称二进制字符串 x 大于二进制字符串 y 。
 * @Date: 2020/12/30
 */

public class Solution3 {
    public static String maximumBinaryString(String binary) {
        int left = 0, right = 0, n = binary.length();
        boolean flag = true;
        char[] chs = binary.toCharArray();
        for (char c : chs) {
            flag = (flag && c == '1');
            left += flag ? 1 : 0;
            right += (!flag && c == '1') ? 1 : 0;
        }

        if (left + right < n - 1) {
            int k = n - right - 1;
            for (int i = 0; i < n; i++) {
                chs[i] = (i == k) ? '0' : '1';
            }
        }
        return new String(chs);
    }

    public static String maximumBinaryString2(String binary) {
        char[] cs = binary.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '0') {
                int c = 0;
                for (int j = i + 1; j < cs.length; j++) {
                    c += cs[j] - '0';
                }
                if (c == cs.length - 1 - i)
                    return binary;
                Arrays.fill(cs, i, cs.length, '1');
                cs[cs.length - c - 1] = '0';
                break;
            }
        }
        return new String(cs);
    }

    public static void main(String[] args) {
        System.out.println(maximumBinaryString("000110"));//111011
    }
}
