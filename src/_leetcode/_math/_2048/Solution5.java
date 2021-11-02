package _leetcode._math._2048;

/**
 * @Description: 贪心优化
 * @Date: 2021/10/31
 */

public class Solution5 {
    public long nextBeautifulNumber(long n) {
        String numStr = Long.toString(n);
        int len = numStr.length();
        int[] bitCnt = new int[10];// 统计各位数字的个数
        int[] bit = new int[len + 1];// 倒序存储数位
        int idx = 0;
        while (n > 0) {
            int tmp = (int) (n % 10L);
            bit[idx++] = tmp;
            bitCnt[tmp]++;
            n /= 10L;
        }
        for (int i = 0; i < bit.length; i++) {
            if (i == bit.length - 1) len += 1;// 当前长度找不到时新增一位
            int val = bit[i] + 1;
            bitCnt[val - 1]--;// 减小原值的统计个数
            while (val < 10) {// 每位都递增到9检测
                bitCnt[val]++;
                int[] bitTmp = new int[bitCnt.length];
                System.arraycopy(bitCnt, 0, bitTmp, 0, bitCnt.length);
                if (isLegal(bitTmp, len)) {
                    bit[i] = val; // 先填充当前位
                    return getAns(bitTmp, bit, i);// 填充低位的数值得到答案
                }
                // 不合法要更新bitCnt
                bitCnt[val]--;
                val++;
            }
        }
        return -1;
    }

    // 从idx开始，根据bitCnt和bit填充低位数值
    private long getAns(int[] bitCnt, int[] bit, int idx) {
        int[] remain = new int[10];// 剩余未使用的数值个数统计数组
        for (int i = 0; i < bitCnt.length; i++)
            if (bitCnt[i] != 0)
                remain[i] = bitCnt[i] == -1 ? i : i - bitCnt[i];
        for (int i = 0; i < idx; i++)
            for (int j = remain.length - 1; j >= 0; j--)// 尽量将最大的数值填到最低位
                if (remain[j] > 0) {
                    bit[i] = j;
                    remain[j]--;
                    break;
                }
        long res = 0L;
        for (int i = 0; i < bit.length; i++)
            res += bit[i] * (long) Math.pow(10, i);
        return res;
    }

    // 检查是否符合数值平衡数条件
    private boolean isLegal(int[] bitCnt, int len) {
        if (bitCnt[0] > 0) return false;// 含有0直接非法
        for (int i = 1; i < bitCnt.length; i++) {
            if (bitCnt[i] > i || len < 0) return false;
            if (bitCnt[i] != 0) len -= i;
        }
        if (len == 0) return true;
        // len > 0时, 考虑未使用的数值可否加和得到len
        return fillBit(bitCnt, len, 1);
    }

    // 从idx开始遍历，寻找bitCnt中未使用的数值，求和能否得到len
    private boolean fillBit(int[] bitCnt, int len, int idx) {
        if (len == 0) return true;
        if (len < 0 || idx == bitCnt.length) return false;
        if (bitCnt[idx] != 0) {
            return fillBit(bitCnt, len, idx + 1);
        } else {
            bitCnt[idx] = -1;// 使用该数值并标记为-1
            if (!fillBit(bitCnt, len - idx, idx + 1)) {
                bitCnt[idx] = 0;
                return fillBit(bitCnt, len, idx + 1);
            }
            return true;
        }
    }
}
                        