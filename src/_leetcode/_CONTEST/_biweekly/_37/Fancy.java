package _leetcode._CONTEST._biweekly._37;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * @Description: 1622. 奇妙序列
 * 请你实现三个 API append，addAll 和 multAll 来实现奇妙序列。
 *
 * 请实现 Fancy 类 ：
 * 1.Fancy() 初始化一个空序列对象。
 * 2.void append(val) 将整数 val 添加在序列末尾。
 * 3.void addAll(inc) 将所有序列中的现有数值都增加 inc 。
 * 4.void multAll(m) 将序列中的所有现有数值都乘以整数 m 。
 * 5.int getIndex(idx) 得到下标为 idx 处的数值（下标从 0 开始），并将结果对 109 + 7 取余。如果下标大于等于序列的长度，请返回 -1 。
 * @Author: matreeix
 * @Date: 2020/10/24
 */

//测试会超时
public class Fancy {
    private final int p = 1_000_000_007;
    private final BigInteger bigP = BigInteger.valueOf(p);
    private final ArrayList<BigInteger> arr = new ArrayList<>();
    private BigInteger a = BigInteger.ONE;
    private BigInteger b = BigInteger.ZERO;
    private BigInteger revA = a;

    public void append(int val) {
        if (revA == null) revA = a.modInverse(bigP);
        arr.add(BigInteger.valueOf(val).add(bigP).subtract(b).multiply(revA).mod(bigP));
    }

    public void addAll(int inc) {
        b = b.add(BigInteger.valueOf(inc)).mod(bigP);
    }

    public void multAll(int m) {
        a = a.multiply(BigInteger.valueOf(m)).mod(bigP);
        b = b.multiply(BigInteger.valueOf(m).mod(bigP));
        revA = null;
    }

    public int getIndex(int idx) {
        if (idx >= arr.size()) return -1;
        return arr.get(idx).multiply(a).add(b).mod(bigP).intValue();
    }

    public static void main(String[] args) {
        Fancy obj = new Fancy();
        obj.append(1);
        obj.addAll(2);
        obj.multAll(3);
        int param_4 = obj.getIndex(0);
    }
}
