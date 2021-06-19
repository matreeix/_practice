package _leetcode._CONTEST._weekly._209;

/**
 * @Description: 1611. 使整数变为 0 的最少操作次数
 * 给你一个整数 n，你需要重复执行多次下述操作将其转换为 0 ：
 * <p>
 * 1.翻转 n 的二进制表示中最右侧位（第 0 位）。
 * 2.如果第 (i-1) 位为 1 且从第 (i-2) 位到第 0 位都为 0，则翻转 n 的二进制表示中的第 i 位。
 * 返回将 n 转换为 0 的最小操作次数。
 * @Author: matreeix
 * @Date: 2020/10/8
 */

public class Solution4 {
    public static int minimumOneBitOperations(int n) {
        int cnt1 = 0;
        int tmp1 = n;
        while (tmp1 != 0) {
            tmp1 = reverse2(tmp1);
            cnt1++;
            if (tmp1 != 0) {
                tmp1 = reverse1(tmp1);
                cnt1++;
            }
        }
        return cnt1;
    }

    public static int minimumOneBitOperations2(int n) {
        int ans = 0;
        while (n > 0) {
            ans ^= n;
            n /= 2;
        }
        return ans;
    }

    //1.翻转 n 的二进制表示中最右侧位（第 0 位）。
    public static int reverse1(int n) {
        return n % 2 == 0 ? n + 1 : n - 1;
    }

    //2.如果第 (i-1) 位为 1 且从第 (i-2) 位到第 0 位都为 0，则翻转 n 的二进制表示中的第 i 位。
    public static int reverse2(int n) {
        int a = Integer.lowestOneBit(n);
        int mark = (n / a - 1) / 2 % 2;
        return mark == 1 ? n - 2 * a : n + 2 * a;
    }

    public static void main(String[] args) {
//        System.out.println(minimumOneBitOperations(9));
        System.out.println(minimumOneBitOperations(17));
        System.out.println(minimumOneBitOperations2(333));
//        System.out.println(minimumOneBitOperations(333));
//        System.out.println(Integer.toBinaryString(333));
    }
}
