package _leetcode._search._668;

/**
 * @Description: 668. 乘法表中第k小的数
 * 几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？
 * 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
 * @Date: 2021/12/1
 */

public class Solution {
    public int findKthNumber(int m, int n, int k) {
        int tmpM = m, tmpN = n;
        m = Math.min(tmpM, tmpN);
        n = Math.max(tmpM, tmpN);
        int l = 1;
        int r = m * n;
        for (int cnt = 0; l < r; cnt = 0) {
            int mid = l + (r - l) / 2;
            for (int i = 1, j = n; i <= m; i++) {
                while (j >= 1 && i * j > mid) j--;
                cnt += j;
            }
            if (cnt < k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
