package _CONTEST._weekly._216;

/**
 * @Description: 1663. 具有给定数值的最小字符串
 * 小写字符 的 数值 是它在字母表中的位置（从 1 开始），因此 a 的数值为 1 ，b 的数值为 2 ，c 的数值为 3 ，以此类推。
 * 字符串由若干小写字符组成，字符串的数值 为各字符的数值之和。例如，字符串 "abe" 的数值等于 1 + 2 + 5 = 8 。
 * 给你两个整数 n 和 k 。返回 长度 等于 n 且 数值 等于 k 的 字典序最小 的字符串。
 * 注意，如果字符串 x 在字典排序中位于 y 之前，就认为 x 字典序比 y 小，有以下两种情况：
 * 1.x 是 y 的一个前缀；
 * 2.如果 i 是 x[i] != y[i] 的第一个位置，且 x[i] 在字母表中的位置比 y[i] 靠前。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * n <= k <= 26 * n
 * @Author: matreeix
 * @Date: 2020/11/24
 */

public class Solution2 {

    public static String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int cntA = 0, cntZ = 0;
        cntZ = (k - n) / 25;
        cntA = (k - n) % 25 == 0 ? n - cntZ : n - cntZ - 1;
        System.out.println(cntA);
        System.out.println(cntZ);
        while (cntA-- > 0) {
            sb.append('a');
        }
        if ((k - n) % 25 != 0)
            sb.append((char) ('a' + (k - n) % 25));
        while (cntZ-- > 0) {
            sb.append('z');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getSmallestString(3,27));
    }
}
