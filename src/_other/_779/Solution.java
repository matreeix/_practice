package _other._779;

/**
 * @Description:
 * @Author: caffebaby
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
