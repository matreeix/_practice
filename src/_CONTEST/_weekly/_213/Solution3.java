package _CONTEST._weekly._213;

/**
 * @Description: 1641. 统计字典序元音字符串的数目
 * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
 * <p>
 * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
 * @Author: matreeix
 * @Date: 2020/11/1
 */

public class Solution3 {
    //将n划分为5段
    public int countVowelStrings(int n) {
        return (n + 1) * (n + 2) * (n + 3) * (n + 4) / 24;
    }

    //dp
    public int countVowelStrings2(int n) {
        int[] a = new int[55];
        int[] e = new int[55];
        int[] i = new int[55];
        int[] o = new int[55];
        int[] u = new int[55];
        a[1] = 1;
        e[1] = 1;
        i[1] = 1;
        o[1] = 1;
        u[1] = 1;
        for (int index = 2; index <= 50; index++) {
            a[index] = a[index - 1] + e[index - 1] + i[index - 1] + o[index - 1] + u[index - 1];
            e[index] = e[index - 1] + i[index - 1] + o[index - 1] + u[index - 1];
            i[index] = i[index - 1] + o[index - 1] + u[index - 1];
            o[index] = o[index - 1] + u[index - 1];
            u[index] = u[index - 1];
        }
        return a[n] + e[n] + i[n] + o[n] + u[n];
    }

}
