package _leetcode._recursion._779;

/**
 * @Description: 779. 第K个语法符号
 * 在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
 * 给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
 * @Author: matreeix
 * @Date: 2019/8/23 19:51
 */
public class Solution {

    public int kthGrammar(int N, int K) {

        if (N == 1 && K == 1) {
            return 0;
        } else {
            int i = K % 2;
            if (i == 0) {
                K = K / 2;
                N--;
                return kthGrammar(N, K) == 1 ? 0 : 1;//偶数数字，上层对应数和当前数字不等
            } else {
                K = K / 2 + 1;
                N--;
                return kthGrammar(N, K) == 1 ? 1 : 0;//奇数数字，上层对应数和当前数字相等
            }
        }

    }

}
