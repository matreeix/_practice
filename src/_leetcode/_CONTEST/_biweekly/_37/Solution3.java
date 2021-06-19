package _leetcode._CONTEST._biweekly._37;

import java.math.BigInteger;

/**
 * @Description: 5527. 大小为 K 的不重叠线段的数目
 * 给你一维空间的 n 个点，其中第 i 个点（编号从 0 到 n-1）位于 x = i 处，请你找到 恰好 k 个不重叠 线段且每个线段至少覆盖两个点的方案数。
 * 线段的两个端点必须都是 整数坐标 。这 k 个线段不需要全部覆盖全部 n 个点，且它们的端点 可以 重合。
 *
 * 请你返回 k 个不重叠线段的方案数。由于答案可能很大，请将结果对 109 + 7 取余 后返回。
 * @Author: matreeix
 * @Date: 2020/10/18
 */

public class Solution3 {
    public static final int MOD = (int)(1e9 + 7);

    //排列组合法
    public int numberOfSets(int n, int k) {
        BigInteger res = BigInteger.valueOf(1);
        for (int i = 1; i < k * 2 + 1; i++) {
            res = res.multiply(BigInteger.valueOf(n + k - i));
            res = res.divide(BigInteger.valueOf(i));
        }
        res = res.mod(BigInteger.valueOf(MOD));
        return res.intValue();
    }
}
