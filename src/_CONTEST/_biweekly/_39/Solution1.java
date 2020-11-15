package _CONTEST._biweekly._39;

import java.util.Arrays;

/**
 * @Description: 5550. 拆炸弹
 * 你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 k 。
 * 为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。
 * <p>
 * 如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
 * 如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
 * 如果 k == 0 ，将第 i 个数字用 0 替换。
 * 由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1] 。
 * <p>
 * 给你 循环 数组 code 和整数密钥 k ，请你返回解密后的结果来拆除炸弹！
 * @Author: matreeix
 * @Date: 2020/11/14
 */

public class Solution1 {
    public static int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        Arrays.fill(res, 0);
        if (k == 0) return res;
        if (k > 0) {
            for (int i = 0; i < n; i++) {
                for (int j = 1; j <= k; j++) {
                    res[i] += code[(i + j) % n];
                }
            }
        }
        if (k < 0) {
            k = -k;
            for (int i = n - 1; i >= 0; i--) {
                for (int j = 1; j <= k; j++) {
                    int tmp = i - j >= 0 ? (i - j) : (n + i - j);
                    res[i] += code[tmp];
                }
            }
        }
        return res;
    }

    public int[] decrypt2(int[] code, int k) {
        int length = code.length;
        int[] result = new int[length];

        if (k == 0) {
            return result;
        } else {
            for (int i = 0; i < length; i++) {
                int sum = 0;
                for (int j = 0; j < Math.abs(k); j++) {
                    if (k > 0) {
                        sum += code[(i + j + 1) % length];
                    } else {
                        sum += code[(i - j - 1 + length) % length];
                    }
                }
                result[i] = sum;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] code = {2, 4, 9, 3};
        int k = -2;
        System.out.println(Arrays.toString(decrypt(code, k)));
    }
}
