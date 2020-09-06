package _CONTEST._biweekly._34;

/**
 * @Description: 5492. 分割字符串的方案数
 * 给你一个二进制串 s  （一个只包含 0 和 1 的字符串），我们可以将 s 分割成 3 个 非空 字符串 s1, s2, s3 （s1 + s2 + s3 = s）。
 * 请你返回分割 s 的方案数，满足 s1，s2 和 s3 中字符 '1' 的数目相同。
 * 由于答案可能很大，请将它对 10^9 + 7 取余后返回。
 * @Author: matreeix
 * @Date: 2020/9/5
 */

public class Solution2 {
    public int numWays(String s) {
        int cnt = 0;
        for (char ch : s.toCharArray())
            if (ch == '1')
                cnt++;
        if (cnt % 3 != 0) return 0;
        if (cnt == 0) return (int) ((((long) s.length() - 2) * (s.length() - 1) / 2)% 1000000007);
        int mark = cnt / 3;
        cnt = 0;
        int cnt1 = 0, cnt2 = 0;
        for (char ch : s.toCharArray()) {
            if (cnt == mark) cnt1++;
            if (cnt == 2 * mark) cnt2++;
            if (ch == '1') cnt++;
        }
        return (int) (((long) cnt1 * cnt2) % 1000000007);
    }


    public static void main(String[] args) {
        System.out.println((long) 123 * 123456789);
    }
}
