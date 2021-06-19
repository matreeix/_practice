package _leetcode._CONTEST._biweekly._37;

/**
 * @Description:
 * @Author: matreeix
 * @Date: 2020/10/24
 */
//某些测试用例无法通过
public class Fancy2 {
    private static final int MOD = 1000000007;
    private static final int SIZE = 100001;

    private int[] seq = new int[SIZE];
    private long[] add = new long[SIZE];
    private long[] mult = new long[SIZE];
    private int count = 0;

    public Fancy2() {
        add[0] = 0;
        mult[0] = 1;
    }

    public void append(int val) {
        seq[count] = val;
        add[count + 1] = add[count];
        mult[count + 1] = mult[count];
        count++;
    }

    public void addAll(int inc) {
        add[count] += inc;
    }

    public void multAll(int m) {
        mult[count] *= m;
        add[count] *= m;
    }

    public int getIndex(int idx) {
        int id = idx % MOD;
        if (id >= count) { return -1; }
        long m = mult[count] / mult[id];
        long inc = add[count] - add[id] * m;
        return (int)((seq[id] * m + inc) % MOD);
    }
}
