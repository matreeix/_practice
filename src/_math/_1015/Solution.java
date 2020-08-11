package _math._1015;

/**
 * @Description: 给定正整数 K，你需要找出可以被 K 整除的、仅包含数字 1 的最小正整数 N。
 * 返回 N 的长度。如果不存在这样的 N，就返回 -1。
 * @Author: caffebaby
 * @Date: 2020/4/28
 */
public class Solution {
    public static int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) {
            return -1;
        }
        int temp = 1;
        int len = 1;
        while (temp % K != 0) {
            temp = temp % K;
            temp = temp * 10 + 1;
            len += 1;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(smallestRepunitDivByK(1));
        System.out.println(smallestRepunitDivByK(2));
        System.out.println(smallestRepunitDivByK(10));
        System.out.println(smallestRepunitDivByK(123123));
    }
}
