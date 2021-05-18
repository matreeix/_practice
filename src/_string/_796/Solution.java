package _string._796;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @Description: 796. 旋转字符串
 * 给定两个字符串, A 和 B。
 * A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。
 * @Created by: matreeix
 * @Date: 2021/5/4
 */
public class Solution {
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }

    //KMP
    public boolean rotateString2(String A, String B) {
        int N = A.length();
        if (N != B.length()) return false;
        if (N == 0) return true;

        //Compute shift table
        int[] shifts = new int[N+1];
        Arrays.fill(shifts, 1);
        int left = -1;
        for (int right = 0; right < N; ++right) {
            while (left >= 0 && (B.charAt(left) != B.charAt(right)))
                left -= shifts[left];
            shifts[right + 1] = right - left++;
        }

        //Find match of B in A+A
        int matchLen = 0;
        for (char c: (A+A).toCharArray()) {
            while (matchLen >= 0 && B.charAt(matchLen) != c)
                matchLen -= shifts[matchLen];
            if (++matchLen == N) return true;
        }

        return false;
    }

    //Rabin-Karp 字符串哈希
    public boolean rotateString3(String A, String B) {
        if (A.equals(B)) return true;

        int MOD = 1_000_000_007;
        int P = 113;
        int Pinv = BigInteger.valueOf(P).modInverse(BigInteger.valueOf(MOD)).intValue();

        long hb = 0, power = 1;
        for (char x: B.toCharArray()) {
            hb = (hb + power * x) % MOD;
            power = power * P % MOD;
        }

        long ha = 0; power = 1;
        char[] ca = A.toCharArray();
        for (char x: ca) {
            ha = (ha + power * x) % MOD;
            power = power * P % MOD;
        }

        for (int i = 0; i < ca.length; ++i) {
            char x = ca[i];
            ha += power * x - x;
            ha %= MOD;
            ha *= Pinv;
            ha %= MOD;
            if (ha == hb && (A.substring(i+1) + A.substring(0, i+1)).equals(B))
                return true;

        }
        return false;
    }
}
