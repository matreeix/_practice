package _leetcode._Cracking_the_Coding_Interview._17._09;


/**
 * @Description: 面试题 17.09. 第 k 个数
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。
 * 注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 * @Author: matreeix
 * @Date: 2020/12/12
 */

public class Solution {
    public static int getKthMagicNumber(int k) {
        int[] numList = new int[k + 1];
        int p3 = 0, p5 = 0, p7 = 0;
        numList[0] = 1;
        for (int i = 1; i < k; i++) {
            numList[i] = Math.min(Math.min(numList[p3] * 3, numList[p5] * 5), numList[p7] * 7);
            if (numList[i] == numList[p3] * 3) p3++;
            if (numList[i] == numList[p5] * 5) p5++;
            if (numList[i] == numList[p7] * 7) p7++;
        }
        return numList[k - 1];
    }

    public static void main(String[] args) {
        System.out.println(getKthMagicNumber(50));
    }
}
