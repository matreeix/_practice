package _leetcode._math._2048;

/**
 * @Description: 暴力枚举法
 * @Date: 2021/10/27
 */

public class Solution2 {

    // 由于数据范围是[1,1000000],最大的数值平衡数是1224444
    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; i <= 1224444; i++) {
            if (isBeautifulNumber(i)) {
                return i;
            }
            if (i > 666666) {
                return 1224444;
            }
        }
        return 0;
    }

    private boolean isBeautifulNumber(int n) {
        int[] tmp = new int[10];
        while (n > 0) {
            int bit = n % 10;
            if (bit == 0 || bit >= 7) return false;
            tmp[bit]++;
            if (tmp[bit] > bit) return false;
            n /= 10;
        }
        for (int i = 1; i < 7; i++) {
            if (tmp[i] != i && tmp[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.isBeautifulNumber(22));
    }
}
