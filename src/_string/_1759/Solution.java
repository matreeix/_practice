package _string._1759;


/**
 * @Description: 1759. 统计同构子字符串的数目
 * 给你一个字符串 s ，返回 s 中 同构子字符串 的数目。由于答案可能很大，只需返回对 109 + 7 取余 后的结果。
 * 同构字符串 的定义为：如果一个字符串中的所有字符都相同，那么该字符串就是同构字符串。
 * 子字符串 是字符串中的一个连续字符序列。
 * @Date: 2021/2/21
 */

public class Solution {
    public int countHomogenous(String s) {
        int[] cnt = new int[100001];//统计字符连续出现频数
        int l = 0, r = 0, mod = 1000000007;
        while (r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                r++;
                if (r == s.length()) {
                    int len = r - l;
                    cnt[len]++;
                }
            } else {
                int len = r - l;
                cnt[len]++;
                l = r;
            }
        }
        long res = 0;
        for (int i = 1; i < cnt.length; i++)
            if (cnt[i] != 0)
                res += ((long) i * (i + 1) / 2L) * cnt[i];

        return (int) (res % mod);
    }

    //Lee神解法
    public int countHomogenous2(String s) {
        int res = 0, cur = 0, count = 0, mod = 1_000_000_007;
        for (int i = 0; i < s.length(); ++i) {
            count = s.charAt(i) == cur ? count + 1 : 1;
            cur = s.charAt(i);
            res = (res + count) % mod;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println((new Solution()).countHomogenous2("abbcccaa"));//13
        System.out.println((new Solution()).countHomogenous2("zzzzz"));//15
        System.out.println((new Solution()).countHomogenous2("xy"));//2
    }
}
