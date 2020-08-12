package _DP._552;

/**
 * @Description: 学生出勤记录II
 * @Author: matreeix
 * @Date: 5/11/2020
 */
public class Solution {
    final int MOD = 1000000007;
    final int M = 6;

    //时间复杂度O(n),空间复杂度O(n)
    public int checkRecord(int n) {
        if (n == 1) return 3;
        if (n == 2) return 8;
        int m = 1000000007;

        /**
         * P(n) is the total number of all possible attendance records ended with 'P' with length n.
         * L(n) is the total number of all possible attendance records ended with 'L' with length n.
         * A(n) is the total number of all possible attendance records ended with 'A' with length n.
         * */
        int[] A = new int[n];
        int[] P = new int[n];
        int[] L = new int[n];

        P[0] = 1;
        L[0] = 1;
        L[1] = 3;
        A[0] = 1;
        A[1] = 2;
        A[2] = 4;

        if (n == 1) return 3;

        for (int i = 1; i < n; i++) {
            A[i - 1] %= m;
            P[i - 1] %= m;
            L[i - 1] %= m;

            //P(n) = A(n - 1) + P(n - 1) + L(n - 1), n ≥ 2.
            P[i] = ((A[i - 1] + P[i - 1]) % m + L[i - 1]) % m;

            if (i > 1)
                //L(n) = A(n - 1) + P(n - 1) + A(n - 2) + P(n - 2), n ≥ 3
                L[i] = ((A[i - 1] + P[i - 1]) % m + (A[i - 2] + P[i - 2]) % m) % m;

            if (i > 2)
            /**
             * assume:
             * noAP(n) is the total number of all possible attendance records ended with 'P' with length n and with no 'A'.
             * noAL(n) is the total number of all possible attendance records ended with 'L' with length n and with no 'A'.
             *
             * get:
             * noAP(n) = noAP(n - 1) + noAL(n - 1), n ≥ 2.
             * noAL(n) = noAP(n - 1) + noAP(n - 2), n ≥ 3.
             * A(n) = noAP(n - 1) + noAL(n - 1), n ≥ 2.
             *
             * can be simplified to:
             *
             * A(n) = A(n - 1) + A(n - 2) + A(n - 3), n ≥ 4.
             *
             * */
                A[i] = ((A[i - 1] + A[i - 2]) % m + A[i - 3]) % m;
        }
        return ((A[n - 1] % m + P[n - 1] % m) % m + L[n - 1] % m) % m;

    }

    //时间复杂度O(n)

    /**
     * 令f[i][j][k]表示有效长度为i的序列的，其中：
     * <p>
     * j表示 A 的个数。
     * k表示最长连续 L 的个数。
     */
    public int checkRecord2Init(int n) {
        final int MOD = 1000000007;
        int[][][] f = new int[n + 1][2][3];

        f[0] = new int[][]{{1, 1, 1}, {1, 1, 1}};
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < 2; j++)
                for (int k = 0; k < 3; k++) {
                    int val = f[i - 1][j][2]; // ...P
                    if (j > 0) val = (val + f[i - 1][j - 1][2]) % MOD; // ...A
                    if (k > 0) val = (val + f[i - 1][j][k - 1]) % MOD; // ...L
                    f[i][j][k] = val;
                }
        return f[n][1][2];
    }

    //矩阵的乘法
    private int[][] mul(int[][] A, int[][] B) {
        int[][] C = new int[M][M];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < M; j++)
                for (int k = 0; k < M; k++)
                    C[i][j] = (int) ((C[i][j] + (long) A[i][k] * B[k][j]) % MOD);
        return C;
    }

    private int[][] pow(int[][] A, int n) {
        int[][] res = new int[M][M];
        for (int i = 0; i < M; i++)
            res[i][i] = 1;
        while (n > 0) {
            if (n % 2 == 1)
                res = mul(res, A);
            A = mul(A, A);
            n /= 2;
        }
        return res;
    }

    //时间复杂度O(log n)

    /**
     * 如果我们将f[i][][]和f[i-1][][]作为两个向量，则可以表示f[i][j][k]为：
     * <p>
     * f[i][0][0]   | 0 0 1 0 0 0 |   f[i-1][0][0]
     * f[i][0][1]   | 1 0 1 0 0 0 |   f[i-1][0][1]
     * f[i][0][2] = | 0 1 1 0 0 0 | * f[i-1][0][2]
     * f[i][1][0]   | 0 0 1 0 0 1 |   f[i-1][1][0]
     * f[i][1][1]   | 0 0 1 1 0 1 |   f[i-1][1][1]
     * f[i][1][2]   | 0 0 1 0 1 1 |   f[i-1][1][2]
     */
    public int checkRecord2Opt(int n) {
        int[][] A = {
                {0, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 0},
                {0, 1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 1},
                {0, 0, 1, 1, 0, 1},
                {0, 0, 1, 0, 1, 1},
        };
        return pow(A, n + 1)[5][2];
    }

    //先考虑只含有P、L的情况，在将A插入进去即可
    public int checkRecord3(int n) {
        long[] PorL = new long[n + 1]; // ending with P or L, no A
        long[] P = new long[n + 1]; // ending with P, no A
        PorL[0] = P[0] = 1;
        PorL[1] = 2;
        P[1] = 1;

        for (int i = 2; i <= n; i++) {
            P[i] = PorL[i - 1];
            PorL[i] = (P[i] + P[i - 1] + P[i - 2]) % MOD;
        }

        long res = PorL[n];
        for (int i = 0; i < n; i++) { // inserting A into (n-1)-length strings
            long s = (PorL[i] * PorL[n - i - 1]) % MOD;
            res = (res + s) % MOD;
        }

        return (int) res;
    }
}
