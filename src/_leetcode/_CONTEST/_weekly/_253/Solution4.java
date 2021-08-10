package _leetcode._CONTEST._weekly._253;

/**
 * @Description: 5841. 找出到每个位置为止最长的有效障碍赛跑路线
 * 你打算构建一些障碍赛跑路线。给你一个 下标从 0 开始 的整数数组 obstacles ，数组长度为 n ，其中 obstacles[i] 表示第 i 个障碍的高度。
 * 对于每个介于 0 和 n - 1 之间（包含 0 和 n - 1）的下标  i ，在满足下述条件的前提下，请你找出 obstacles 能构成的最长障碍路线的长度：
 * 你可以选择下标介于 0 到 i 之间（包含 0 和 i）的任意个障碍。
 * 在这条路线中，必须包含第 i 个障碍。
 * 你必须按障碍在 obstacles 中的 出现顺序 布置这些障碍。
 * 除第一个障碍外，路线中每个障碍的高度都必须和前一个障碍 相同 或者 更高 。
 * 返回长度为 n 的答案数组 ans ，其中 ans[i] 是上面所述的下标 i 对应的最长障碍赛跑路线的长度。
 * 提示：
 * <p>
 * n == obstacles.length
 * 1 <= n <= 10^5
 * 1 <= obstacles[i] <= 10^7
 * @Date: 2021/8/8
 */

public class Solution4 {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length, length = 0, res[] = new int[n], mono[] = new int[n];
        for (int i = 0; i < n; ++i) {
            int l = 0, r = length;
            while (l < r) {
                int m = (l + r) / 2;
                if (mono[m] <= obstacles[i]) l = m + 1;
                else r = m;
            }
            res[i] = l + 1;
            if (length == l) length++;
            mono[l] = obstacles[i];
        }
        return res;
    }
}
