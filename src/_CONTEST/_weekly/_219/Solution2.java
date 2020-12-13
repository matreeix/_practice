package _CONTEST._weekly._219;

/**
 * @Description: 5626. 十-二进制数的最少数目
 * 如果一个十进制数字不含任何前导零，且每一位上的数字不是 0 就是 1 ，那么该数字就是一个 十-二进制数 。例如，101 和 1100 都是 十-二进制数，而 112 和 3001 不是。
 * 给你一个表示十进制整数的字符串 n ，返回和为 n 的 十-二进制数 的最少数目。
 * 提示：
 * 1 <= n.length <= 105
 * n 仅由数字组成
 * n 不含任何前导零并总是表示正整数
 * @Author: matreeix
 * @Date: 2020/12/13
 */

public class Solution2 {
    public static int minPartitions(String n) {
        int max = 0;//max表示n中的最大数字
        for (char ch : n.toCharArray()) {
            max = Math.max(max, ch - '0');
            if (max == 9)
                break;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(minPartitions("32"));
        System.out.println(minPartitions("82734"));
        System.out.println(minPartitions("27346209830709182346"));
    }
}
