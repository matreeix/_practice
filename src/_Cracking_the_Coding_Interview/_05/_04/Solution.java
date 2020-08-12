package _Cracking_the_Coding_Interview._05._04;

import java.util.Arrays;

/**
 * @Description: 面试题 05.04. 下一个数
 * 下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）
 * @Author: matreeix
 * @Date: 2020/6/30
 */

public class Solution {
    /**
     * 原理：
     * 最接近的较小值:二进制表示中从右向左找前面有0的第一个1,"10"中的1,0换位,剩下右边的二进制位前后翻转
     * 解释:从低位向高位找第一个可以被低位0替换的1使数变小,同时低位在保持0,1个数不变时要尽可能大,分析发现在满足前面查找条件右边的0,1分布:空,"0000"(全是0),“0011”(全1开始全0结束)和“11111”(全是1),只需要把他们前后翻转就能把所有1移动到高位实现剩余右边值最大
     * 最接近的较大值:二进制表示中从右向左找前面有1的第一个0,"01"中的1,0换位,剩下右边的二进制位前后翻转
     * 解释:从低位向高位找第一个可以被低位1替换的0使数变大,同时低位在保持0,1个数不变时要尽可能小,分析发现在满足前面查找条件右边的0,1分布:空,"0000"(全是0),“1100”(全0开始全1结束)和“11111”(全是1),只需要把他们前后翻转就能把所有0移动到高位实现剩余边右值最小
     */
    //花里胡哨法
    public static int[] findClosedNumbers(int num) {
        if (num == Integer.MAX_VALUE) return new int[]{-1, -1};
        int max = -1;
        int min = -1;
        int i = 0, j = 0, k = 0;
        while ((num & 1) == 0) {
            num >>= 1;
            i++;
            j++;
            k++;
        }
        if (i != 0)
            min = (num - 1) << i | 1 << i - 1;
        while ((num & 1) == 1) {
            num >>= 1;
            j++;
            k++;
        }

        max = (num + 1) << j | ((1 << j - i - 1) - 1);
        if (i == 0) {
            while ((num & 1) == 0 && k != 32) {
                num >>= 1;
                k++;
            }
            min = k == 32 ? -1 : (num - 1) << k | (((1 << j - i + 1) - 1) << (k - (j - i + 1)));
        }
        System.out.println("i:" + i + ",j:" + j + ",k:" + k);
        int[] res = new int[2];
        res[0] = max;
        res[1] = min;
        return res;
    }

    //暴力高效法
    public static int[] findClosedNumbers2(int num) {
        int max = -1, min = -1;
        int cnt = Integer.bitCount(num);
        for (int i = num + 1; ; i++) {
            if (i < 0) break;
            if (Integer.bitCount(i) == cnt) {
                max = i;
                break;
            }
            if (i == Integer.MIN_VALUE) break;
        }
        for (int i = num - 1; i > 0; i--) {
            if (Integer.bitCount(i) == cnt) {
                min = i;
                break;
            }
        }
        return new int[]{max, min};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findClosedNumbers(1)));
        System.out.println(Arrays.toString(findClosedNumbers(2)));
    }
}