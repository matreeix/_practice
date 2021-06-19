package _leetcode._CONTEST._biweekly._44;

/**
 * @Description: 5647. 解码异或后的排列
 * 给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 * 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 * 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。
 * @Date: 2021/1/23
 */

public class Solution3 {

    public int[] decode(int[] encoded) {
        int n = encoded.length;
        int[] v = new int[n + 1];

        int all = 0; // 全部 n 个正整数的异或值
        for (int i = 1; i <= n + 1; i++) all ^= i;
        int all_but_first = 0; // 除开第一个数的异或值
        for (int i = 1; i < n; i += 2)
            all_but_first ^= encoded[i];
        v[0] = all ^ all_but_first; // 得到第一个数
        for (int i = 1; i <= n; i++)
            v[i] = v[i - 1] ^ encoded[i - 1];
        return v;
    }
}
