package _leetcode._math._2048;

import java.util.Arrays;

/**
 * @Description: 贪心算法
 * @Date: 2021/10/28
 */

public class Solution4 {
    public long nextBeautifulNumber(long n) {
        int d[] = new int[20];
        long x = n;
        int l = 0;
        // 将n解析为数位数组
        while (x > 0) {
            d[l++] = (int)(x % 10L);
            x /= 10;
        }
        // 因为可能在与n相同的位数范围内无解，所以高位增加一个，保证能找到解
        d[l++] = 0;
        boolean isFindAns = false;
        // 从低位到高位枚举每一位数字，表示这一位上的数字增加，保证严格大于n
        for (int i = 0; i < l; i++) {
            // 枚举的范围为[d[i]+1, 9]
            for (int j = d[i] + 1; j <= 9; j++) {
                // 统计高位上每个数字出现的次数
                int cnt[] = new int[20];
                Arrays.fill(cnt, 0);
                cnt[j]++;
                for (int k = i + 1; k < l; k++) {
                    if ((k == l - 1) && (d[k] == 0)) continue;
                    cnt[d[k]]++;
                }
                // sum表示当前情况下，有多少位数字可以更改，也就是i位以前的都可以改，因为i位的数字已经保证比n大
                int sum = i;
                boolean isOK = true;
                for (int k = 0; k <= 9; k++) {
                    if (cnt[k] > k) {
                        isOK = false;
                        break;
                    }
                    if (cnt[k] == 0) continue;
                    // 这是高位上数字还需要补充多少个
                    sum -= k - cnt[k];
                }
                if (sum < 0 || !isOK) {
                    continue;
                } else if (sum >= 0) {
                    // 高位的补充完了，还剩下没确定的，需要再用其他数字补充
                    // 枚举如何补充，其实就是从0-9中找到和等于sum的组合
                    for (int m = 0; m < (1 << 9); m++) {
                        x = m;
                        int p = 0;
                        boolean isFindTmp = true;
                        int tmp = 0;
                        while (x > 0) {
                            if ((x & 1) == 1) {
                                // 如果这个组合在前面高位出现过，那不符合条件，跳过
                                if (cnt[p] != 0) {
                                    isFindTmp = false;
                                    break;
                                }
                                tmp += p;
                            }
                            x >>= 1;
                            p++;
                        }
                        if (!isFindTmp || tmp != sum) continue;

                        d[i] = j;
                        // 填充数组的顺序为越大的数组越低位，这样才能保证大于n，但是最小，r数组对要补充的数组进行排序
                        int r[] = new int[20];
                        Arrays.fill(r, 0);
                        x = m;
                        p = 0;
                        while (x > 0) {
                            if ((x & 1) == 1) {
                                r[p] = 1;
                            }
                            x >>= 1;
                            p++;
                        }
                        r[j] = 1;
                        for (int k = i + 1; k < l; k++) {
                            if ((k == l - 1) && (d[k] == 0)) continue;
                            if (d[k] > cnt[d[k]])
                                r[d[k]] = 1;
                        }
                        // 填充数字
                        int left = 0;
                        for (int k = 9; k > 0; k--) {
                            if (r[k] == 0) continue;
                            while (cnt[k] < k) {
                                d[left++] = k;
                                cnt[k]++;
                            }
                        }
                        isFindAns = true;
                        break;
                    }

                }
                if (isFindAns) break;
            }
            if (isFindAns) break;
        }

        // 将数组组合成数字
        int ans = 0;
        for (int i = l - 1; i >= 0; i--) {
            if (i == l - 1 && d[i] == 0) {
                continue;
            }
            ans = ans * 10 + d[i];
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
