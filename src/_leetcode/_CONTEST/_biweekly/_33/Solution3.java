package _leetcode._CONTEST._biweekly._33;

/**
 * @Description: 得到目标数组的最少函数调用次数
 * 给你一个与 nums 大小相同且初始值全为 0 的数组 arr ，请你调用 modify 函数得到整数数组 nums 。
 * 请你返回将 arr 变成 nums 的最少函数调用次数。
 * 答案保证在 32 位有符号整数以内。
 * @Author: matreeix
 * @Date: 2020/8/22
 */

public class Solution3 {

    private void modify(int[] arr, int op, int idx) {
        if (op == 0)
            arr[idx] = arr[idx] + 1;
        if (op == 1)
            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] * 2;
            }
    }

    /**
     * 倒推法：
     * 1.数组中某个数是奇数，只能单独减一，减一的总次数就是所有的二进制形式中bit-1的个数和
     * 2.所有数都是偶数，直接除以2，除以2的最大次数就是最大数除以2的次数
     * */
    public int minOperations(int[] A) {
        int res = 0, maxLen = 0;
        for (int a : A) {
            int bits = 0;
            while (a > 0) {
                res += a & 1;
                bits++;
                a >>= 1;
            }
            maxLen = Math.max(maxLen, bits);
        }
        return res + maxLen - 1;

    }

    //简洁写法
    public int minOperations2(int[] A) {
        int res = 0, max = 0;
        for (int a : A) {
            if (a == 0) continue;
            res += Integer.bitCount(a);//统计减1的次数
            max = Math.max(max, Integer.numberOfTrailingZeros(Integer.highestOneBit(a)));//统计除以2的次数
        }
        return res + max;
    }

    public static void main(String[] args) {
        System.out.println(Integer.highestOneBit(5));
        System.out.println(Integer.numberOfTrailingZeros(4));
    }
}
