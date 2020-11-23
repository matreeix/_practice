package _CONTEST._weekly._215;

/**
 * @Description: 1659. 最大化网格幸福感
 * 给你四个整数 m、n、introvertsCount 和 extrovertsCount 。有一个 m x n 网格，和两种类型的人：内向的人和外向的人。总共有 introvertsCount 个内向的人和 extrovertsCount 个外向的人。
 * <p>
 * 请你决定网格中应当居住多少人，并为每个人分配一个网格单元。 注意，不必 让所有人都生活在网格中。
 * <p>
 * 每个人的 幸福感 计算如下：
 * <p>
 * 1.内向的人 开始 时有 120 个幸福感，但每存在一个邻居（内向的或外向的）他都会 失去  30 个幸福感。
 * 2.外向的人 开始 时有 40 个幸福感，每存在一个邻居（内向的或外向的）他都会 得到  20 个幸福感。
 * 邻居是指居住在一个人所在单元的上、下、左、右四个直接相邻的单元中的其他人。
 * <p>
 * 网格幸福感 是每个人幸福感的 总和 。 返回 最大可能的网格幸福感 。
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 5
 * 0 <= introvertsCount, extrovertsCount <= min(m * n, 6)
 * @Author: matreeix
 * @Date: 2020/11/21
 */

public class Solution4 {
    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        //优化
        if (m < n) {//m>n
            m ^= n;
            n ^= m;
            m ^= n;
        }
        int highBit = 1;
        for (int i = 1; i < n; i++)
            highBit *= 3;

        int state = highBit * 3;

        int[][][] dp = new int[state][introvertsCount + 1][extrovertsCount + 1];
        dp[0][introvertsCount][extrovertsCount] = 1; //初始化置为正值，以便与不可达状态0区分，即假设没人的时候幸福度为1，结果再减回1即可。
        int[][][] nextDp = null;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nextDp = new int[state][introvertsCount + 1][extrovertsCount + 1];
                for (int preState = 0; preState < state; preState++) {
                    for (int introvert = 0; introvert <= introvertsCount; introvert++) {
                        for (int extrovert = 0; extrovert <= extrovertsCount; extrovert++) {
                            if (dp[preState][introvert][extrovert] == 0) continue;

                            //put 0，blank on [i, j]
                            int nextState = (preState % highBit) * 3;
                            nextDp[nextState][introvert][extrovert] = Math.max(nextDp[nextState][introvert][extrovert], dp[preState][introvert][extrovert]);

                            int upStateBit = i == 0 ? 0 : preState / highBit;
                            int leftStateBit = j == 0 ? 0 : preState % 3;

                            //put 1，introvert person on [i, j]
                            nextState++;
                            if (introvert > 0)
                                nextDp[nextState][introvert - 1][extrovert] = Math.max(nextDp[nextState][introvert - 1][extrovert],
                                        dp[preState][introvert][extrovert] + 120 + calcDiff(upStateBit, -30) + calcDiff(leftStateBit, -30));


                            //put 2, extrovert person on [i, j]
                            nextState++;
                            if (extrovert > 0)
                                nextDp[nextState][introvert][extrovert - 1] = Math.max(nextDp[nextState][introvert][extrovert - 1],
                                        dp[preState][introvert][extrovert] + 40 + calcDiff(upStateBit, 20) + calcDiff(leftStateBit, 20));
                        }
                    }
                }
                dp = nextDp;
            }
        }
        int ans = 0;
        for (int preState = 0; preState < state; preState++)
            for (int introvert = 0; introvert <= introvertsCount; introvert++)
                for (int extrovert = 0; extrovert <= extrovertsCount; extrovert++)
                    ans = Math.max(ans, dp[preState][introvert][extrovert]);

        return ans - 1;
    }

    //根据相邻位置的状态，计算在[i, j] 放入指定person后， diff的变化值
    private int calcDiff(int stateBit, int offset) {
        if (stateBit == 0) return 0;
        return offset + (stateBit == 1 ? -30 : 20);
    }
}
