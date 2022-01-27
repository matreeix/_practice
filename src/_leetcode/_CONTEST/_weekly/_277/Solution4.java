package _leetcode._CONTEST._weekly._277;

/**
 * @Description: 5992. 基于陈述统计最多好人数
 * 好人：该角色只说真话。
 * 坏人：该角色可能说真话，也可能说假话。
 * 给你一个下标从 0 开始的二维整数数组 statements ，大小为 n x n ，表示 n 个玩家对彼此角色的陈述。具体来说，statements[i][j] 可以是下述值之一：
 * 0 表示 i 的陈述认为 j 是 坏人 。
 * 1 表示 i 的陈述认为 j 是 好人 。
 * 2 表示 i 没有对 j 作出陈述。
 * 另外，玩家不会对自己进行陈述。形式上，对所有 0 <= i < n ，都有 statements[i][i] = 2 。
 * 根据这 n 个玩家的陈述，返回可以认为是 好人 的 最大 数目。
 * 提示：
 * n == statements.length == statements[i].length
 * 2 <= n <= 15
 * statements[i][j] 的值为 0、1 或 2
 * statements[i][i] == 2
 * @Date: 2022/1/23
 */

public class Solution4 {
    public int maximumGood(int[][] statements) {
        int n = statements.length;
        int res = 0;
        for (int mask = (1 << n) - 1; mask > 0; mask--) {
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (((1 << i) & mask) != 0) {
                    for (int j = 0; j < n; j++) {
                        if ((statements[i][j] == 1 && ((1 << j) & mask) == 0)
                                || (statements[i][j] == 0 && ((1 << j) & mask) != 0)) {//矛盾
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) break;
                }
            }
            if (flag) {// 遍历完所有人，或者遇到矛盾就退出
                int tmp = 0;
                for (int i = 0; i < n; i++)
                    if (((1 << i) & mask) != 0)
                        tmp++;
                res = Math.max(tmp, res);
            }
        }
        return res;
    }
}
